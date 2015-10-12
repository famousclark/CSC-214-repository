package mobappdev.lecture12.customlistview;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture12.R;

public class CustomListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        FragmentManager manager = getFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.frame_layout_custom_list_view);
        if(fragment == null) {
           fragment = new CustomComicListFragment();
           manager.beginTransaction()
                   .add(R.id.frame_layout_custom_list_view, fragment)
                   .commit();
        }
    }
}
