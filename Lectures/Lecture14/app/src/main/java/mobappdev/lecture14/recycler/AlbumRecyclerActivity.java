package mobappdev.lecture14.recycler;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture14.R;

public class AlbumRecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_recycler);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.frame_layout_recycler, new AlbumRecyclerFragment())
                .commit();

        ActionBar aBar = getSupportActionBar();
        aBar.setTitle(R.string.title_album_list);
        aBar.setSubtitle(getString(R.string.subtitle_recycler_view_version));
    }
}
