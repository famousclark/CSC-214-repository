package mobappdev.lecture16.camera;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import mobappdev.lecture16.OneFragment;

public class CameraActivity extends OneFragment {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, CameraActivity.class);
        return intent;
    }

    public Fragment getFragment() {
        return new CameraFragment();
    }
}
