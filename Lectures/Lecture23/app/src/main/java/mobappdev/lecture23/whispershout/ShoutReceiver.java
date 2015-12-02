package mobappdev.lecture23.whispershout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

public class ShoutReceiver extends BroadcastReceiver {
    public ShoutReceiver() {
    }

    public IntentFilter getIntentFilter() {
        return new IntentFilter(WhisperShoutFragment.ACTION_SHOUT);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String shout = intent.getStringExtra(WhisperShoutFragment.EXTRA_SHOUT);
        Toast.makeText(context, "Heard a Shout: " + shout, Toast.LENGTH_LONG).show();
    }
}
