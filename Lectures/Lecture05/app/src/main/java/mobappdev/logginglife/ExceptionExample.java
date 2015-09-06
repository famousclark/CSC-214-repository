package mobappdev.logginglife;

import android.util.Log;

/**
 * Created by Bobby on 9/6/2015.
 */
public class ExceptionExample {
    private static final String TAG = "ExceptionExample";

    public void doSomething() throws NastyException {
        throw new NastyException("BOOM!");
    }

    public void handleException() {
        try {
            doSomething();
        } catch (NastyException e) {
            Log.e(TAG, "Nasty Exception handled!", e);
        }
    }
}
