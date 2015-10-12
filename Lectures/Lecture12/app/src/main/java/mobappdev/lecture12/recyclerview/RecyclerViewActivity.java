package mobappdev.lecture12.recyclerview;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture12.R;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        FragmentManager manager = getFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.frame_layout_recycler_view);
        if(fragment == null) {
            fragment = new ComicRecyclerViewFragment();
            manager.beginTransaction()
                    .add(R.id.frame_layout_recycler_view, fragment)
                    .commit();
        }
    }
}
