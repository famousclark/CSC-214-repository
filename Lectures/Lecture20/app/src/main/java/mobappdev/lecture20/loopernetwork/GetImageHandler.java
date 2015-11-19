package mobappdev.lecture20.loopernetwork;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

import java.io.IOException;

import mobappdev.lecture20.HttpHelper;

/**
 * Created by Bobby on 11/18/2015.
 */
public class GetImageHandler extends HandlerThread {
    private static final String TAG = "GetImageHandlerTag";
    private static final int MESSAGE_DOWNLOAD_IMAGES = 5678;

    public interface DownloadProgressListener {
        public void imagesDownloadedSoFar(int number);
        public void downloadComplete();
    }

    private Handler mHandler;
    private Handler mResponseHandler;
    private DownloadProgressListener mListener;

    public GetImageHandler(Handler responseHandler) {
        super(TAG);
        mResponseHandler = responseHandler;
    }

    public void setDownloadProgressListener(DownloadProgressListener listener) {
        mListener = listener;
    }

    public void downloadImages(String url) {
        mHandler.obtainMessage(MESSAGE_DOWNLOAD_IMAGES, url).sendToTarget();
    }

    @Override
    protected void onLooperPrepared() {
        mHandler = new DownloadHandler();
    }

    private class DownloadHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == MESSAGE_DOWNLOAD_IMAGES) {
                final String url = msg.obj.toString();
                HttpHelper helper = new HttpHelper();
                boolean succeeded = true;
                for(int i=1; succeeded  && i<=100; i++) {
                    try {
                        helper.getBytes(url);
                        final int number = i;
                        mResponseHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mListener.imagesDownloadedSoFar(number);
                            }
                        });
                    }
                    catch(IOException ioe) {
                        Log.e(TAG, "Failed to get image: " + url);
                        succeeded = false;
                    }
                }
                mResponseHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mListener.downloadComplete();
                    }
                });
            }
        }
    }
}
