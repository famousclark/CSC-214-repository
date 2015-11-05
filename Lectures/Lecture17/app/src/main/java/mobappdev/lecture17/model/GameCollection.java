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
    private List<VideoGame> mGamesList;

    private GameCollection(Context context) {
        mDao = VGDAO.get(context);
        mGames = null;
        mGamesList = null;
    }

    public static synchronized GameCollection get(Context context) {
        if(COLLECTION == null) {
            COLLECTION = new GameCollection(context);
        }
        return COLLECTION;
    }

    public List<VideoGame> getGames() {
        return getGames(false);
    }

    public List<VideoGame> getGames(boolean force) {
        if(force || mGames == null) {
            mGames = mDao.getVideoGames();
            mGamesList = new ArrayList<>(mGames.size());

            for(VideoGame game:mGames.values()) {
                mGamesList.add(game);
            }
        }
        return mGamesList;
    }

    public void addGame(VideoGame game) {
        mDao.addVideoGame(game);
        mGames.put(game.getId(), game);
        mGamesList.add(game);
    }

    public VideoGame getGame(UUID id) {
        return mGames.get(id);
    }

    public void updateGame(VideoGame game) {
        mDao.updateVideoGame(game);
    }
}
