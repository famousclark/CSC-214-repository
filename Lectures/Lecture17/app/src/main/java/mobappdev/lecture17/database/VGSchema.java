package mobappdev.lecture17.database;

/**
 * Created by USX13992 on 11/5/2015.
 */
public class VGSchema {
    public static final String DATABASE_NAME = "videogames.dp";
    public static final int VERSION = 1;

    public static class VideoGames {
        public static final String TABLE_NAME = "video_games";

        public static class Cols {
            public static final String ID = "id";
            public static final String TITLE = "title";
            public static final String GENRE = "genre";
            public static final String STUDIO = "studio";
            public static final String PUBLISHER = "publisher";
            public static final String RELEASE_YEAR = "release_year";
        }
    }
}
