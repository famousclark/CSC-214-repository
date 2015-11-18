package mobappdev.lecture20.serialnetwork;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture20.Fragtivity;
import mobappdev.lecture20.R;

public class SerialNetworkActivity extends Fragtivity {

    public static Intent newIntent(Context c) {
        return new Intent(c, SerialNetworkActivity.class);
    }

    @Override
    public Fragment createFragment() {
        return SerialNetworkFragment.newInstance();
    }
}
