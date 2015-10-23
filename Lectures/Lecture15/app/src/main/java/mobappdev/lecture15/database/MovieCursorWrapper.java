package mobappdev.lecture15.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.Date;
import java.util.UUID;

import mobappdev.lecture15.database.MovieDbSchema.MovieTable;
import mobappdev.lecture15.model.Movie;

/**
 * Created by USX13992 on 10/23/2015.
 */
public class MovieCursorWrapper extends CursorWrapper {

    public MovieCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Movie getMovie() {
        UUID id = UUID.fromString(getString(getColumnIndex(MovieTable.Cols.ID)));
        String title = getString(getColumnIndex(MovieTable.Cols.TITLE));
        String director = getString(getColumnIndex(MovieTable.Cols.DIRECTOR));
        String genre = getString(getColumnIndex(MovieTable.Cols.GENRE));
        Date releaseDate = new Date(getLong(getColumnIndex(MovieTable.Cols.RELEASE_DATE)));

        Movie movie = new Movie(id);
        movie.setTitle(title);
        movie.setDirector(director);
        movie.setGenre(genre);
        movie.setReleaseDate(releaseDate);

        return movie;
    }
}
