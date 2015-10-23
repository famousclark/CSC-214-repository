package mobappdev.lecture15.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by USX13992 on 10/22/2015.
 */
public class Movie {
    private UUID mId;
    private String mTitle;
    private String mDirector;
    private String mGenre;
    private Date mReleaseDate;

    public Movie() {
        this(UUID.randomUUID());
    }

    public Movie(UUID id) {
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

    public String getDirector() {
        return mDirector;
    }

    public void setDirector(String director) {
        mDirector = director;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }

    public Date getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        mReleaseDate = releaseDate;
    }
}
