package mobappdev.lecture20.asyncnetwork;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture20.R;

public class AsyncNetworkActivity extends AppCompatActivity {

    public static Intent newIntent(Context c) {
        return new Intent(c, AsyncNetworkActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_network);

        FragmentManager manager = getSupportFragmentManager();
        if(manager.findFragmentById(R.id.frame_layout_async_network) == null) {
            manager.beginTransaction()
                    .add(R.id.frame_layout_async_network, AsyncNetworkFragment.newInstance())
                    .commit();
        }
    }
}
