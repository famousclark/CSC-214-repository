package mobappdev.lecture22;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture22.receiver.ReceiverActivity;

public class MainActivity extends Fragtivity {

    @Override
    public Fragment createFragment() {
        return MainFragment.newInstance();
    }
}
