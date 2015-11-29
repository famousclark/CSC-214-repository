package mobappdev.lecture22.bowser;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import mobappdev.lecture22.Fragtivity;
import mobappdev.lecture22.R;

public class WebBowserActivity extends Fragtivity {
    @Override
    public Fragment createFragment() {
        return WebBowserFragment.newInstance();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, WebBowserActivity.class);
    }
}
