package mobappdev.lecture20.asyncnetwork;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture20.Fragtivity;
import mobappdev.lecture20.R;

public class AsyncNetworkActivity extends Fragtivity {
    public static Intent newIntent(Context c) {
        return new Intent(c, AsyncNetworkActivity.class);
    }

    @Override
    public Fragment createFragment() {
        return AsyncNetworkFragment.newInstance();
    }
}
