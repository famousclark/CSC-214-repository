package mobappdev.lecture23spy;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bobby on 12/1/2015.
 *
 * Helper class that stores overheard messages.
 */
public class Prefs {
    private static final String KEY_EAVESDROPPINGS = "EAVESDROPPINGS";

    public static Set<String> getEavesdroppings(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getStringSet(KEY_EAVESDROPPINGS, new HashSet<String>());
    }

    public static void addEavesdropping(Context context, String eavesdropping) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Set<String> eavesdroppings = getEavesdroppings(context);
        eavesdroppings.add(eavesdropping);
        prefs.edit()
                .putStringSet(KEY_EAVESDROPPINGS, eavesdroppings)
                .apply();
    }
}
