package mobappdev.lecture21.mediaplayer;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import mobappdev.lecture21.Fragtivity;

/**
 * Created by Bobby on 11/23/2015.
 */
public class MediaPlayerActivity extends Fragtivity {
    public static Intent newIntent(Context c) {
        return new Intent(c, MediaPlayerActivity.class);
    }

    @Override
    public Fragment createFragment() {
        return MediaPlayerFragment.newInstance();
    }
}
