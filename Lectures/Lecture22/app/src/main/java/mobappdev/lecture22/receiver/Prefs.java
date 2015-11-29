package mobappdev.lecture22.receiver;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Bobby on 11/29/2015.
 */
public class Prefs {
    private static final String PREF_BOOT_TIME = "boot.time";

    public static void setBootTime(Context context, long time) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putLong(PREF_BOOT_TIME, time).apply();
    }

    public static long getBootTime(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getLong(PREF_BOOT_TIME, 0);
    }
}
