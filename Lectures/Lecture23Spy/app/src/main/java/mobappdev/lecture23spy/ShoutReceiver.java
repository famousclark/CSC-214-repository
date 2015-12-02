package mobappdev.lecture23spy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ShoutReceiver extends BroadcastReceiver {
    private static final String TAG = "ShoutRcvrLog";
    private static final String EXTRA_SHOUT = "mobappdev.lecture23.extra.SHOUT";

    public ShoutReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String eavesdropping = intent.getStringExtra(EXTRA_SHOUT);
        String shout = context.getResources().getString(R.string.shout);
        Prefs.addEavesdropping(context, String.format(shout, eavesdropping));
        Log.i(TAG, "Overheard some juicy gossip: " + eavesdropping);
    }
}
