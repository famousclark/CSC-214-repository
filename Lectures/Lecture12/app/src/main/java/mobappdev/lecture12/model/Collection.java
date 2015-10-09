package mobappdev.lecture12.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by USX13992 on 10/9/2015.
 */
public class Collection {
    private static Collection sCollection;
    private Context mAppContext;
    private Map<UUID,Comic> collection;

    private Collection(Context appContext) {
        mAppContext = appContext;
        collection = new HashMap<>();
        // a list of comics is needed!
        addComic("Action Comics", 1, 1, "First Superman", false);
        addComic("Amazing Fantasy", 1, 15, "First Spider-Man", false);
        addComic("Detective Comics", 1, 27, "First Batman", false);
        addComic("Teenage Mutant Ninja Turtles", 1, 1, "First TMNT", true);
        addComic("The Incredible Hulk", 1, 181, "First Wolverine", true);
        addComic("The Incredible Hulk", 1, 331, "First Peter David", true);
        addComic("The Crow", 1, 1, "First Crow", true);
        addComic("Batman", 1, 1, "New 52", true);
        addComic("Fantastic Four", 1, 48, "First Silver Surfer, Galactus", true);
        addComic("Uncanny X-Men", 1, 1, "First X-Men", false);
        addComic("Uncanny X-Men", 1, 17, "Early X-Men", true);
        addComic("Amazing Spider-Man", 1, 129, "First Punisher", false);
        addComic("Amazing Spider-Man", 1, 298, "First Todd McFarlane", true);
        addComic("The Incredible Hulk", 2, 1, "New Series", true);
    }

    public static Collection get(Context c) {
        if(sCollection == null) {
            sCollection = new Collection(c);
        }
        return sCollection;
    }

    public List<Comic> getCollection() {
        List<Comic> comics = new ArrayList<>(collection.size());
        comics.addAll(collection.values());
        Collections.sort(comics, new ComicComparator());
        return comics;
    }

    public Comic getComic(UUID id) {
        return collection.get(id);
    }

    private void addComic(String series, int volume, int number, String note, boolean owned) {
        Comic comic = new Comic(series, volume, number, note, owned);
        collection.put(comic.getId(), comic);
    }
}
