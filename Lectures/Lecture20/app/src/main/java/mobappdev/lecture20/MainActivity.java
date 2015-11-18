package mobappdev.lecture20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mobappdev.lecture20.asyncnetwork.AsyncNetworkActivity;
import mobappdev.lecture20.badnetwork.BadNetworkActivity;

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
}
