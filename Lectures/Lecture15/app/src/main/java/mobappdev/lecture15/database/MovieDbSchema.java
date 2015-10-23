package mobappdev.lecture15.database;

/**
 * Created by USX13992 on 10/22/2015.
 */
public class MovieDbSchema {
    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "movies_database.db";

    public static final class MovieTable {
        public static final String NAME = "movies";

        public static final class Cols {
            public static final String ID = "id";
            public static final String TITLE = "title";
            public static final String DIRECTOR = "director";
            public static final String GENRE = "genre";
            public static final String RELEASE_DATE = "release_date";
        }
    }
}
