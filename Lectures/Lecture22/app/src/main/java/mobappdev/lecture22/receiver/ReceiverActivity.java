package mobappdev.lecture22.receiver;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture22.Fragtivity;

public class ReceiverActivity extends Fragtivity {

    @Override
    public Fragment createFragment() {
        return ReceiverFragment.newInstance();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, ReceiverActivity.class);
    }

}
