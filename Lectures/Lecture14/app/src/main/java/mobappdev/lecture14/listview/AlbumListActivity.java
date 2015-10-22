package mobappdev.lecture14.listview;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture14.R;

public class AlbumListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);


        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.frame_layout_list_view, new AlbumListFragment())
                .commit();

        getSupportActionBar().setTitle(R.string.title_album_list);
        getSupportActionBar().setSubtitle(R.string.subtitle_list_view_version);
    }
}
