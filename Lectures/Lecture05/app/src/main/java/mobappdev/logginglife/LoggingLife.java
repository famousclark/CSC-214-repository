package mobappdev.logginglife;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class LoggingLife extends Activity {

    private static final String TAG = "LoggingLife";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");

        setContentView(R.layout.activity_logging_life);
    }
}
