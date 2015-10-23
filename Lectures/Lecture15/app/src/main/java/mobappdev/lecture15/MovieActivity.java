package mobappdev.lecture15;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

import mobappdev.lecture15.model.Movie;

public class MovieActivity extends AppCompatActivity
        implements MovieFragment.OnMovieChangedListener {

    public static final String EXTRA_ID = "mobappdev.lecture15.moviefragment.id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Intent intent = getIntent();
        UUID id = (UUID)intent.getSerializableExtra(EXTRA_ID);
        MovieFragment fragment = MovieFragment.newInstance(id);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.frame_layout_movie, fragment, null)
                .commit();

        int rid = (id == null ? R.string.subtitle_new_movie : R.string.subtitle_edit_movie);
        getSupportActionBar().setSubtitle(rid);
    }

    public static Intent newIntent(Context context, UUID id) {
        Intent intent = new Intent(context, MovieActivity.class);
        intent.putExtra(EXTRA_ID, id);
        return intent;
    }

    @Override
    public void onMovieChanged(Movie movie) {
        // todo: update or add movie to the database
    }
}
