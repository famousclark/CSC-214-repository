package mobappdev.project02.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bobby on 11/10/2015.
 */
public class Project2OpenHelper extends SQLiteOpenHelper {
    public Project2OpenHelper(Context context) {
        super(context, Schema.DATABASE_NAME, null, Schema.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Schema.Users.NAME
                + "(_id integer primary key autoincrement, "
                + Schema.Users.Cols.EMAIL + ", "
                + Schema.Users.Cols.PASSWORD + ", "
                + Schema.Users.Cols.FULL_NAME + ", "
                + Schema.Users.Cols.BIRTH_DATE + ", "
                + Schema.Users.Cols.PROFILE_PIC + ")"
        );

        db.execSQL("CREATE TABLE " + Schema.FeedItems.NAME
                + "(_id integer primary key autoincrement, "
                + Schema.FeedItems.Cols.EMAIL + ", "
                + Schema.FeedItems.Cols.POSTED_DATE + ", "
                + Schema.FeedItems.Cols.CONTENT + ", "
                + Schema.FeedItems.Cols.PHOTO_PATH + ")"
        );

        db.execSQL("CREATE TABLE " + Schema.FeedItems.NAME
                + "(_id integer primary key autoincrement, "
                + Schema.Favorites.Cols.EMAIL + ", "
                + Schema.Favorites.Cols.FAVORITE + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // nope
    }
}
