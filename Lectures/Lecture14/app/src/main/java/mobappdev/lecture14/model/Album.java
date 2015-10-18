package mobappdev.lecture14.model;

import java.util.UUID;

/**
 * Created by Bobby on 10/18/2015.
 */
public class Album {
    private UUID mId;
    private String mName;
    private String mArtist;
    private String mGenre;
    private int mTrackCount;

    public Album(String name, String artist, String genre, int trackCount) {
        mId = UUID.randomUUID();
        mName = name;
        mArtist = artist;
        mGenre = genre;
        mTrackCount = trackCount;
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getGenre() {
        return mGenre;
    }

    public int getTrackCount() {
        return mTrackCount;
    }
}
