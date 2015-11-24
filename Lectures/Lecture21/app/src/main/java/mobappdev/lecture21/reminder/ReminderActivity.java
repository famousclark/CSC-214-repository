package mobappdev.lecture21.reminder;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture21.Fragtivity;

public class ReminderActivity extends Fragtivity {

    public static Intent newIntent(Context c) {
        return new Intent(c, ReminderActivity.class);
    }

    @Override
    public Fragment createFragment() {
        return ReminderFragment.newInstance();
    }
}
