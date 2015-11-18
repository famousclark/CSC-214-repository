package mobappdev.lecture20.badnetwork;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture20.R;

public class BadNetworkActivity extends AppCompatActivity {

    public static Intent newIntent(Context c) {
        return new Intent(c, BadNetworkActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_network);

        FragmentManager manager = getSupportFragmentManager();
        if(manager.findFragmentById(R.id.frame_layout_bad_network) == null) {
            manager.beginTransaction()
                    .add(R.id.frame_layout_bad_network, BadNetworkFragment.newInstance())
                    .commit();
        }
    }
}
