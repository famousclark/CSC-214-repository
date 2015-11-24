package mobappdev.lecture21.reminder;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import mobappdev.lecture21.MainActivity;
import mobappdev.lecture21.R;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class ReminderService extends IntentService {
    private static final String TAG = "ReminderServiceTag";
    private static final int RC_REMINDER = 123;
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    public ReminderService() {
        super(TAG);
    }

    public static Intent newIntent(Context c, String message) {
        Intent i = new Intent(c, ReminderService.class);
        i.putExtra(EXTRA_MESSAGE, message);
        return i;
    }

    public static void newReminder(Context c, String message, int minutes) {
        Intent i = newIntent(c, message);
        PendingIntent pi = PendingIntent.getService(
                c,            // context
                RC_REMINDER,  // request code (similar to startActivityForResult)
                i,            // the intent
                0);           // flags

        int ms = minutes * 60 * 1000;
        long timeToGoOff = SystemClock.elapsedRealtime() + ms;

        Log.i(TAG, "Setting reminder: msg=" + message + ", minutes: " + minutes);
        AlarmManager manager = (AlarmManager)c.getSystemService(Context.ALARM_SERVICE);
        manager.setExact(
                AlarmManager.ELAPSED_REALTIME, // elapsed realtime (time since boot)
                timeToGoOff,                   // time in ms
                pi                             // the pending intent to use
        );
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "Intent received; handling: " + intent);
        if (intent != null) {
            String message = intent.getStringExtra(EXTRA_MESSAGE);

            Intent main = MainActivity.newIntent(this);
            PendingIntent pi = PendingIntent.getActivity(
                    this,
                    0,
                    main,
                    0
            );

            Notification notification = new NotificationCompat.Builder(this)
                    .setTicker(message)
                    .setSmallIcon(R.drawable.ic_clock)
                    .setContentTitle(getString(R.string.title_reminder))
                    .setContentText(message)
                    .setContentIntent(pi)
                    .setAutoCancel(true)
                    .build();

            NotificationManagerCompat manager = NotificationManagerCompat.from(this);
            manager.notify(0, notification);
        }
    }

}
