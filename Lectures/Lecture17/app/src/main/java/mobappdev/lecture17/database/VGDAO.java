package mobappdev.lecture17.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import mobappdev.lecture17.model.VideoGame;

/**
 * Created by USX13992 on 11/5/2015.
 */
public class VGDAO {
    private static VGDAO DAO = null;

    private SQLiteDatabase mDatabase;

    private VGDAO(Context context) {
        mDatabase = new VGOpenHelper(context).getWritableDatabase();
    }

    public static synchronized VGDAO get(Context context) {
        if(DAO == null) {
            DAO = new VGDAO(context);
        }
        return DAO;
    }

    public void addVideoGame(VideoGame game) {
        mDatabase.insert(
                VGSchema.VideoGames.TABLE_NAME,
                null,
                getContentValues(game)
        );
    }

    public VideoGame getVideoGame(UUID id) {
        VGCursorWrapper wrapper = queryVideoGames(
          VGSchema.VideoGames.Cols.ID + "=?",
          new String[] { id.toString() }
        );

        VideoGame game = null;
        if(wrapper.getCount() != 0) {
            wrapper.moveToFirst();
            game = wrapper.getVideoGame();
        }
        wrapper.close();

        return game;
    }

    public Map<UUID, VideoGame> getVideoGames() {
        Map<UUID, VideoGame> games = new HashMap<>();

        VGCursorWrapper wrapper = queryVideoGames(null, null);
        wrapper.moveToFirst();
        while(wrapper.isAfterLast() == false) {
            VideoGame game = wrapper.getVideoGame();
            games.put(game.getId(), game);
        }
        wrapper.close();
        return games;
    }

    public void updateVideoGame(VideoGame game) {
        String id = game.getId().toString();
        ContentValues values = getContentValues(game);
        mDatabase.update(
                VGSchema.VideoGames.TABLE_NAME,
                values,
                VGSchema.VideoGames.Cols.ID + "=?",
                new String[] {id}
        );
    }

    private static ContentValues getContentValues(VideoGame game) {
        ContentValues values = new ContentValues();

        values.put(VGSchema.VideoGames.Cols.ID, game.getId().toString());
        values.put(VGSchema.VideoGames.Cols.TITLE, game.getTitle());
        values.put(VGSchema.VideoGames.Cols.GENRE, game.getGenre());
        values.put(VGSchema.VideoGames.Cols.STUDIO, game.getStudio());
        values.put(VGSchema.VideoGames.Cols.PUBLISHER, game.getPublisher());
        values.put(VGSchema.VideoGames.Cols.RELEASE_YEAR, game.getReleaseYear());

        return values;
    }

    private VGCursorWrapper queryVideoGames(String where, String[] args) {
        Cursor cursor = mDatabase.query(
                VGSchema.VideoGames.TABLE_NAME,
                null,
                where,
                args,
                null,
                null,
                null
        );
        return new VGCursorWrapper(cursor);
    }
}
