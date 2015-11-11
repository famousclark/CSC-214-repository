package mobappdev.project02.database;

/**
 * Created by Bobby on 11/10/2015.
 */
public class Schema {
    public static final String DATABASE_NAME = "project02.db";
    public static final int VERSION = 1;

    public static class Users {
        public static final String NAME = "users";
        public static class Cols {
            public static final String EMAIL = "email";
            public static final String PASSWORD = "password";
            public static final String FULL_NAME = "full_name";
            public static final String BIRTH_DATE = "birth_date";
            public static final String PROFILE_PIC = "profile_pic";
        }
    }

    public static class FeedItems {
        public static final String NAME = "feed_items";
        public static class Cols {
            public static final String EMAIL = "email";
            public static final String POSTED_DATE = "posted_date";
            public static final String CONTENT = "content";
            public static final String PHOTO_PATH = "photo_path";
        }
    }

    public static class Favorites {
        public static final String NAME = "favorites";
        public static class Cols {
            public static final String EMAIL = "email";
            public static final String FAVORITE = "favorite";
        }
    }
}
