package mobappdev.lecture23.talktomyself;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

public class ReceiverTwo extends BroadcastReceiver {
    private static final String TAG = "ReceiverTwoLog";

    private boolean mTrap;

    public ReceiverTwo() {

    }

    public void shouldTrapBroadcast(boolean trap) {
        mTrap = trap;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Received broadcast: " + intent.getAction());
        int resultCode;
        if(mTrap) {
            Log.i(TAG, "Trapping broadcast!");
            resultCode = Activity.RESULT_CANCELED;
        }
        else {
            resultCode = Activity.RESULT_OK;
        }
        setResultCode(resultCode);
    }
}
