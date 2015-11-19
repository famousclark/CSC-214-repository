package mobappdev.lecture20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mobappdev.lecture20.asyncnetwork.AsyncNetworkActivity;
import mobappdev.lecture20.badnetwork.BadNetworkActivity;
import mobappdev.lecture20.loopernetwork.LooperNetworkActivity;
import mobappdev.lecture20.serialnetwork.SerialNetworkActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startBadNetwork(View view) {
        startActivity(BadNetworkActivity.newIntent(this));
    }

    public void startAsyncNetwork(View view) {
        startActivity(AsyncNetworkActivity.newIntent(this));
    }

    public void startSerialNetwork(View view) {
        startActivity(SerialNetworkActivity.newIntent(this));
    }

    public void startLooperNetwork(View view) {
        startActivity(LooperNetworkActivity.newIntent(this));
    }
}
