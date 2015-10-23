package mobappdev.lecture15.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import mobappdev.lecture15.database.MovieCursorWrapper;
import mobappdev.lecture15.database.MovieDbSchema;
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
        mMovies.clear();
        MovieCursorWrapper wrapper = queryMovies(null, null);

        try {
            wrapper.moveToFirst();
            while(wrapper.isAfterLast() == false) {
                mMovies.add(wrapper.getMovie());
                wrapper.moveToNext();
            }
        }
        finally {
            wrapper.close();
        }

        return mMovies;
    }

    public void addMovie(Movie movie) {
        ContentValues values = getContentvalues(movie);
        mDatabase.insert(MovieDbSchema.MovieTable.NAME, null, values);
    }

    public void updateMovie(Movie movie) {
        String id = movie.getId().toString();
        ContentValues values = getContentvalues(movie);
        mDatabase.update(MovieDbSchema.MovieTable.NAME,
                values,
                MovieDbSchema.MovieTable.Cols.ID + "=?",
                new String[]{id});
    }

    public Movie getMovie(UUID id) {
        return mMoviesMap.get(id);
    }

    private static ContentValues getContentvalues(Movie movie) {
        ContentValues values = new ContentValues();

        values.put(MovieDbSchema.MovieTable.Cols.ID, movie.getId().toString());
        values.put(MovieDbSchema.MovieTable.Cols.TITLE, movie.getTitle());
        values.put(MovieDbSchema.MovieTable.Cols.DIRECTOR, movie.getDirector());
        values.put(MovieDbSchema.MovieTable.Cols.GENRE, movie.getGenre());
        values.put(MovieDbSchema.MovieTable.Cols.RELEASE_DATE, movie.getReleaseDate().getTime());

        return values;
    }

    private MovieCursorWrapper queryMovies(String where, String[] args) {
        Cursor cursor = mDatabase.query(
                MovieDbSchema.MovieTable.NAME, // table name
                null,                          // which columns; null for all
                where,                         // where clause, e.g. id=?
                args,                          // where arguments
                null,                          // group by
                null,                          // having
                null                           // order by
        );

        return new MovieCursorWrapper(cursor);
    }
}
