package mobappdev.lecture13.model;

import java.util.UUID;

/**
 * Created by USX13992 on 10/9/2015.
 */
public class Comic {
    private String mSeries;
    private int mVolume;
    private int mNumber;
    private String mNote;
    private boolean mOwned;
    private UUID mId;

    public Comic(String series, int volume, int number, String note, boolean owned) {
        mSeries = series;
        mVolume = volume;
        mNumber = number;
        mNote = note;
        mOwned = owned;
        mId = UUID.randomUUID();
    }

    public String getSeries() {
        return mSeries;
    }

    public int getVolume() {
        return mVolume;
    }

    public int getNumber() {
        return mNumber;
    }

    public boolean isOwned() {
        return mOwned;
    }

    public UUID getId() {
        return mId;
    }

    public String getNote() {
        return mNote;
    }

    @Override
    public String toString() {
        return getSeries() + " vol. " + getVolume() + ", #" + getNumber();
    }
}
