package mobappdev.lecture14.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Bobby on 10/18/2015.
 */
public class Collection {
    private static final Collection COLLECTION = new Collection();

    private Map<UUID,Album> albums;

    private Collection() {
        albums = new HashMap<>();

        addAlbum(new Album("Dirt", "Alice in Chains", "Alternative", 13));
        addAlbum(new Album("Rock Spectacle", "Barenaked Ladies", "Alternative", 11));
        addAlbum(new Album("1", "The Beatles", "Rock", 27));
        addAlbum(new Album("Razorlade Suitcase", "Bush", "Alternative", 13));
        addAlbum(new Album("Fashion Nugget", "Cake", "Alternative", 14));
        addAlbum(new Album("God Shuffled His Feet", "Crash Test Dummies", "Alternative", 12));
        addAlbum(new Album("The Real Thing", "Faith No More", "Alternative", 11));
        addAlbum(new Album("American idiot", "Green Day", "Alternative", 12));
        addAlbum(new Album("Night Visions", "Imagine Dragons", "Alternative", 13));
        addAlbum(new Album("In Between Dreams", "Jack Johnson", "Alternative", 14));
        addAlbum(new Album("Happy Hour", "King Missile", "Alternative", 18));
        addAlbum(new Album("Born to Die", "Lana Del Rey", "Alternative", 18));
        addAlbum(new Album("Game Called Life", "Leftover Cuties", "Ukulele Band", 6));
        addAlbum(new Album("It's Not Me, It's You", "Lily Allen", "Alternative", 12));
        addAlbum(new Album("Pure Heroine", "Lourde", "Alternative", 10));
        addAlbum(new Album("The Black Parade", "My Chemical Romance", "Alternative", 14));
        addAlbum(new Album("Unplugged in New York", "Nirvana", "Alternative", 14));
        addAlbum(new Album("Ten", "Pearl Jam", "Alternative", 11));
        addAlbum(new Album("What we Saw From the Cheap Seats", "Regina Spektor", "Alternative",
                14));
    }

    public static Collection get() {
        return COLLECTION;
    }

    public void addAlbum(Album album) {
        albums.put(album.getId(), album);
    }

    public Album getAlbum(UUID id) {
        return albums.get(id);
    }

    public List<Album> getAlbums() {
        List<Album> albumList = new ArrayList<>(albums.size());
        albumList.addAll(albums.values());
        return albumList;
    }
}
