package mobappdev.lecture20.loopernetwork;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import mobappdev.lecture20.Fragtivity;

/**
 * Created by Bobby on 11/18/2015.
 */
public class LooperNetworkActivity extends Fragtivity {

    public static Intent newIntent(Context c) {
        return new Intent(c, LooperNetworkActivity.class);
    }

    @Override
    public Fragment createFragment() {
        return LooperNetworkFragment.newInstance();
    }
}
