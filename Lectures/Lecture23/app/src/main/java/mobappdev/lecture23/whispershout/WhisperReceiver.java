package mobappdev.lecture23.whispershout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

/**
 * Created by Bobby on 12/1/2015.
 */
public class WhisperReceiver extends BroadcastReceiver {
    public IntentFilter getIntentFilter() {
        return new IntentFilter(WhisperShoutFragment.ACTION_WHISPER);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String whisper = intent.getStringExtra(WhisperShoutFragment.EXTRA_WHISPER);
        Toast.makeText(context, "Heard a Whisper: " + whisper, Toast.LENGTH_LONG).show();
    }
}
