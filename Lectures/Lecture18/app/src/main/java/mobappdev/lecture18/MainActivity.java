package mobappdev.lecture18;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();

        TrackListFragment fragment = (TrackListFragment)manager.findFragmentById(R.id.frame_layout_main);
        if(fragment == null) {
            fragment = new TrackListFragment();
            manager.beginTransaction()
                    .add(R.id.frame_layout_main, fragment)
                    .commit();
        }
    }
}
