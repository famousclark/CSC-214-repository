package mobappdev.lecture21.mediaplayer;

/**
 * Created by Bobby on 11/23/2015.
 */
public class Music {
    private final String mName;
    private final String mPath;

    public Music(String name, String path) {
        mName = name;
        mPath = path;
    }

    public String getName() {
        return mName;
    }

    public String getPath() {
        return mPath;
    }
}
