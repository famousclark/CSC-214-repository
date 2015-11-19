package mobappdev.lecture20.loopernetwork;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Bobby on 11/18/2015.
 */
public class ToastHandlerThread extends HandlerThread {
    private static final String TAG = "ToastHandlerTag";
    private static final int MESSAGE_POP = 1234;
    private Handler mHandler;
    private Handler mResponseHandler;
    private ToastListener mListener;

    public interface ToastListener {
        void toastReadyToPop(String message);
    }

    public ToastHandlerThread(Handler responseHandler) {
        super(TAG);
        mResponseHandler = responseHandler;
    }

    public void setToastListener(ToastListener listener) {
        mListener = listener;
    }

    public void popToast(String message) {
        mHandler.obtainMessage(MESSAGE_POP, message).sendToTarget();
    }

    @Override
    protected void onLooperPrepared() {
        mHandler = new ToastHandler();
    }

    private class ToastHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MESSAGE_POP) {
                final String message = msg.obj.toString();
                mResponseHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mListener.toastReadyToPop(message);
                    }
                });
            }
        }
    }
}
