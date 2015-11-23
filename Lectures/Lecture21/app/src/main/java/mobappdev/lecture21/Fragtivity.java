package mobappdev.lecture21;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Bobby on 11/23/2015.
 */
public abstract class Fragtivity extends AppCompatActivity {

    public abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fragtivity);

        FragmentManager manager = getSupportFragmentManager();
        if(manager.findFragmentById(R.id.frame_layout_fragment_container) == null) {
            Fragment fragment = createFragment();
            manager.beginTransaction()
                    .add(R.id.frame_layout_fragment_container, fragment)
                    .commit();
        }
    }
}
