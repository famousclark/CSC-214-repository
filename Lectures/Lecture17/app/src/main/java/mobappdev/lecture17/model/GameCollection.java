package mobappdev.lecture17.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import mobappdev.lecture17.database.VGDAO;

/**
 * Created by USX13992 on 11/5/2015.
 */
public class GameCollection {
    private static GameCollection COLLECTION;

    private VGDAO mDao;
    private Map<UUID,VideoGame> mGames;

    private GameCollection(Context context) {
        mDao = VGDAO.get(context);
        mGames = null;
    }

    public static synchronized GameCollection get(Context context) {
        if(COLLECTION == null) {
            COLLECTION = new GameCollection(context);
        }
        return COLLECTION;
    }

    public List<VideoGame> getGames() {
        mGames = mDao.getVideoGames();
        List<VideoGame> games = new ArrayList<>(mGames.size());

        for(VideoGame game:mGames.values()) {
            games.add(game);
        }

        return games;
    }

    public void addGame(VideoGame game) {
        mDao.addVideoGame(game);
        mGames.put(game.getId(), game);
    }

    public VideoGame getGame(UUID id) {
        return mGames.get(id);
    }

    public void updateGame(VideoGame game) {
        mDao.updateVideoGame(game);
    }
}
