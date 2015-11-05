package mobappdev.lecture17.model;

import java.util.UUID;

/**
 * Created by USX13992 on 11/5/2015.
 */
public class VideoGame {
    private final UUID mId;
    private String mTitle;
    private String mGenre;
    private String mStudio;
    private String mPublisher;
    private int mReleaseYear;

    public VideoGame() {
        this(UUID.randomUUID());
    }

    public VideoGame(UUID id) {
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }

    public String getStudio() {
        return mStudio;
    }

    public void setStudio(String studio) {
        mStudio = studio;
    }

    public String getPublisher() {
        return mPublisher;
    }

    public void setPublisher(String publisher) {
        mPublisher = publisher;
    }

    public int getReleaseYear() {
        return mReleaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        mReleaseYear = releaseYear;
    }
}
