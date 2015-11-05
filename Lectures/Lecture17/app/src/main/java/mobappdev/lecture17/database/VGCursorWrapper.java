package mobappdev.lecture17.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.UUID;

import mobappdev.lecture17.model.VideoGame;

/**
 * Created by USX13992 on 11/5/2015.
 */
public class VGCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public VGCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public VideoGame getVideoGame() {
        UUID id = UUID.fromString(getString(getColumnIndex(VGSchema.VideoGames.Cols.ID)));
        String title = getString(getColumnIndex(VGSchema.VideoGames.Cols.TITLE));
        String genre = getString(getColumnIndex(VGSchema.VideoGames.Cols.GENRE));
        String studio = getString(getColumnIndex(VGSchema.VideoGames.Cols.STUDIO));
        String publisher = getString(getColumnIndex(VGSchema.VideoGames.Cols.PUBLISHER));
        int releaseYear = getInt(getColumnIndex(VGSchema.VideoGames.Cols.RELEASE_YEAR));

        VideoGame game = new VideoGame(id);
        game.setTitle(title);
        game.setGenre(genre);
        game.setStudio(studio);
        game.setPublisher(publisher);
        game.setReleaseYear(releaseYear);

        return game;
    }
}
