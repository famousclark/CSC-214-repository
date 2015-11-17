package mobappdev.lecture19_5;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomewardBoundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeward_bound);

        FragmentManager manager = getSupportFragmentManager();
        if(manager.findFragmentById(R.id.frame_layout_homeward_bound) == null) {
            manager.beginTransaction()
                    .add(R.id.frame_layout_homeward_bound, HomewardBoundFragment.newInstance())
                    .commit();
        }
    }

}
