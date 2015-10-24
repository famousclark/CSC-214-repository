package mobappdev.lecture15;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import mobappdev.lecture15.model.Movie;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MovieListFragment mMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate(Bundle) called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMovieList = new MovieListFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.frame_layout_main, mMovieList, null)
                .commit();

        getSupportActionBar().setSubtitle(R.string.subtitle_movie_list);
        Log.d(TAG, "onCreate(Bundle) returning");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled;
        switch(item.getItemId()) {
            case R.id.menu_item_new_movie:
                Intent intent = MovieActivity.newIntent(this, null);
                startActivityForResult(intent, 0);
                handled = true;
                break;
            default:
                handled = super.onOptionsItemSelected(item);
                break;
        }
        return handled;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK) {
            mMovieList.updateUI();
        }
    }
}
