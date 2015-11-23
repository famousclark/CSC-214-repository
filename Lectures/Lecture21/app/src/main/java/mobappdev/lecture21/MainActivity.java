package mobappdev.lecture21;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Fragtivity {
    @Override
    public Fragment createFragment() {
        return MainFragment.newInstance();
    }
}
