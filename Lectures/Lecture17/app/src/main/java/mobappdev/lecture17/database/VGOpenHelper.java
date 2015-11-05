package mobappdev.lecture17.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USX13992 on 11/5/2015.
 */
public class VGOpenHelper extends SQLiteOpenHelper {
    public VGOpenHelper(Context context) {
        super(context, VGSchema.DATABASE_NAME, null, VGSchema.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + VGSchema.VideoGames.TABLE_NAME
                + "(_id integer primary key autoincrement, "
                + VGSchema.VideoGames.Cols.ID + ", "
                + VGSchema.VideoGames.Cols.TITLE + ", "
                + VGSchema.VideoGames.Cols.GENRE + ", "
                + VGSchema.VideoGames.Cols.STUDIO + ", "
                + VGSchema.VideoGames.Cols.PUBLISHER + ", "
                + VGSchema.VideoGames.Cols.RELEASE_YEAR + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // nah
    }
}
