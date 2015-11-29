package mobappdev.lecture22.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {


    private static final String TAG = "BootReceiverLog";

    public BootReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Intent received: " + intent.getAction());

        Prefs.setBootTime(context, System.currentTimeMillis());
    }
}
