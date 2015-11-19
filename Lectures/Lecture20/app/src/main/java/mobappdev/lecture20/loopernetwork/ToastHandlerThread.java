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
    static final int MESSAGE_POP = 1234;
    private static final String TAG = "ToastHandlerTag";
    private Handler mHandler;
    private Handler mResponseHandler;
    private ToastListener mListener;

    public interface ToastListener extends JobListener<String> {}

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
        mHandler = new ToastHandler(mResponseHandler, mListener);
    }

    private static class ToastHandler extends Handler {
        private final Handler mResponseHandler;
        private final ToastListener mListener;

        public ToastHandler(Handler responseHandler, ToastListener listener) {
            mResponseHandler = responseHandler;
            mListener = listener;
        }

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == ToastHandlerThread.MESSAGE_POP) {
                final String message = msg.obj.toString();
                mResponseHandler.post(new WorkPoster<String>(message, mListener));
            }
        }
    }
}
