package mobappdev.lecture23spy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class WhisperReceiver extends BroadcastReceiver {
    private static final String TAG = "WhisperRcvrLog";
    private static final String EXTRA_WHISPER = "mobappdev.lecture23.extra.WHISPER";

    public WhisperReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String eavesdropping = intent.getStringExtra(EXTRA_WHISPER);
        String whisper = context.getResources().getString(R.string.whisper);
        Prefs.addEavesdropping(context, String.format(whisper, eavesdropping));
        Log.i(TAG, "Overheard whispered gossip: " + eavesdropping);
    }
}
