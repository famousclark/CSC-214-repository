package mobappdev.lecture21.sharedprefs;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture21.Fragtivity;

public class SharedPrefsActivity extends Fragtivity {


    public static Intent newIntent(Context c) {
        return new Intent(c, SharedPrefsActivity.class);
    }

    @Override
    public Fragment createFragment() {
        return SharedPrefsFragment.newInstance();
    }
}
