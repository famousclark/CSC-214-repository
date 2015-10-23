package mobappdev.lecture15.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import mobappdev.lecture15.database.MoviesDatabaseHelper;

/**
 * Created by USX13992 on 10/23/2015.
 */
public class MovieCollection {
    private static MovieCollection sMovieCollection;

    private final Context mContext;
    private final SQLiteDatabase mDatabase;
    private final List<Movie> mMovies;
    private final Map<UUID,Movie> mMoviesMap;

    private MovieCollection(Context context) {
        // make sure to use the application context, not an individual activity because the
        // collection needs to outlive activities that are destroyed
        mContext = context.getApplicationContext();
        // open a connection to the database
        mDatabase = new MoviesDatabaseHelper(mContext).getWritableDatabase();
        // create an empty list of movies
        mMovies = new LinkedList<>();
        mMoviesMap = new HashMap<>();
    }

    public static synchronized MovieCollection get(Context context) {
        if(sMovieCollection == null) {
            sMovieCollection = new MovieCollection(context);
        }
        return sMovieCollection;
    }

    public List<Movie> getMovies() {
        return mMovies;
    }

    public void addMovie(Movie movie) {

    }

    public Movie getMovie(UUID id) {
        return mMoviesMap.get(id);
    }
}
