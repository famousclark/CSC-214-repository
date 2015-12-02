package mobappdev.lecture23;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Fragtivity<MainFragment> {
    @Override
    public MainFragment createFragment() {
        return MainFragment.newInstance();
    }
}
