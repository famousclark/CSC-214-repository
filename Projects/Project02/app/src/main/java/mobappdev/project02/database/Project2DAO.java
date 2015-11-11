package mobappdev.project02.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

import mobappdev.project02.model.FeedItem;
import mobappdev.project02.model.User;

/**
 * Created by Bobby on 11/10/2015.
 */
public class Project2DAO {
    private static Project2DAO SINGLETON;

    private final SQLiteDatabase mDatabase;

    private Project2DAO(Context context) {
        mDatabase = new Project2OpenHelper(context).getWritableDatabase();
    }

    public static Project2DAO get(Context context) {
        if(SINGLETON == null) {
            SINGLETON = new Project2DAO(context);
        }
        return SINGLETON;
    }

    public User getUser(String email, String password) {
        Cursor cursor = mDatabase.query(
                Schema.Users.NAME, // table name
                null,
                "email = ? AND password = ?",
                new String[] { email, password},
                null,
                null,
                null
        );
        UserCursorWrapper wrapper = new UserCursorWrapper(cursor);
        User user;
        if(wrapper.getCount() > 0) {
            wrapper.moveToFirst();
            user = wrapper.getUser();
        }
        else {
            user = null;
        }
        wrapper.close();

        return user;
    }

    public void insertUser(User user) {
        ContentValues values = getUserContentValues(user);
        mDatabase.insert(
                Schema.Users.NAME,
                null,
                values
        );
    }

    public void insertFeedItem(FeedItem item) {
        ContentValues values = getFeedItemContentValues(item);
        mDatabase.insert(
                Schema.FeedItems.NAME,
                null,
                values
        );
    }

    public void insertFavorite(String email, String favorite) {
        ContentValues values = new ContentValues();
        values.put(Schema.Favorites.Cols.EMAIL, email);
        values.put(Schema.Favorites.Cols.FAVORITE, favorite);

        mDatabase.insert(
                Schema.Favorites.NAME,
                null,
                values
        );
    }

    private static ContentValues getUserContentValues(User user) {
        ContentValues values = new ContentValues();

        values.put(Schema.Users.Cols.EMAIL, user.getEmail());
        values.put(Schema.Users.Cols.PASSWORD, user.getPassword());
        values.put(Schema.Users.Cols.FULL_NAME, user.getFullName());
        values.put(Schema.Users.Cols.BIRTH_DATE, user.getBirthDate().getTime());
        values.put(Schema.Users.Cols.PROFILE_PIC, user.getProfilePic());

        return values;
    }

    private static ContentValues getFeedItemContentValues(FeedItem item) {
        ContentValues values = new ContentValues();

        values.put(Schema.FeedItems.Cols.EMAIL, item.getEmail());
        values.put(Schema.FeedItems.Cols.POSTED_DATE, item.getPostedDate().getTime());
        values.put(Schema.FeedItems.Cols.CONTENT, item.getContent());
        values.put(Schema.FeedItems.Cols.PHOTO_PATH, item.getPhotoPath());

        return values;
    }

    private static class UserCursorWrapper extends CursorWrapper {
        public UserCursorWrapper(Cursor cursor) {
            super(cursor);
        }

        public User getUser() {
            User user = new User();

            int emailIndex = getColumnIndex(Schema.Users.Cols.EMAIL);
            String email = getString(emailIndex);
            user.setEmail(email);

            user.setPassword(getString(getColumnIndex(Schema.Users.Cols.PASSWORD)));
            user.setFullName(getString(getColumnIndex(Schema.Users.Cols.FULL_NAME)));
            user.setBirthDate(new Date(getLong(getColumnIndex(Schema.Users.Cols.BIRTH_DATE))));
            user.setProfilePic(getString(getColumnIndex(Schema.Users.Cols.PROFILE_PIC)));

            return user;
        }
    }
}
