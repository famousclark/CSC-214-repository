package mobappdev.lecture15.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mobappdev.lecture15.database.MovieDbSchema.MovieTable;

/**
 * Created by USX13992 on 10/22/2015.
 */
public class MoviesDatabaseHelper extends SQLiteOpenHelper {
    public MoviesDatabaseHelper(Context context) {
        super(context, MovieDbSchema.DATABASE_NAME, null, MovieDbSchema.VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + MovieTable.NAME
                + "(_id integer primary key autoincrement, "
                + MovieTable.Cols.ID + ", "
                + MovieTable.Cols.TITLE + ", "
                + MovieTable.Cols.DIRECTOR + ", "
                + MovieTable.Cols.GENRE + ", "
                + MovieTable.Cols.RELEASE_DATE + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
