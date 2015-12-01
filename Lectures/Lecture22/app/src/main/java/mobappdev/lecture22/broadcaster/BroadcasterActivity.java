package mobappdev.lecture22.broadcaster;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture22.Fragtivity;
import mobappdev.lecture22.R;

public class BroadcasterActivity extends Fragtivity {
    public static Intent newIntent(Context context) {
        return new Intent(context, BroadcasterActivity.class);
    }

    @Override
    public Fragment createFragment() {
        return null;
    }
}
