package mobappdev.lecture23.whispershout;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture23.Fragtivity;
import mobappdev.lecture23.R;

public class WhisperShoutActivity extends Fragtivity<WhisperShoutFragment> {

    public static Intent newIntent(Context context) {
        return new Intent(context, WhisperShoutActivity.class);
    }

    @Override
    public WhisperShoutFragment createFragment() {
        return WhisperShoutFragment.newInstance();
    }
}
