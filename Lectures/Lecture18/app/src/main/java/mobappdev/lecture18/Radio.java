package mobappdev.lecture18;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bobby on 11/11/2015.
 */
public class Radio {
    private static final String TAG = "RadioLog";
    private static final String TRACKS_FOLDER = "tracks";

    private AssetManager mAssets;
    private List<Track> mTracks;
    private SoundPool mSoundPool;

    public Radio(Context context) {
        mAssets = context.getAssets();
        mTracks = new ArrayList<>();
        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        String[] trackNames;
        try {
            trackNames = mAssets.list(TRACKS_FOLDER);
            int i = 1;
            for(String filename : trackNames) {
                String path = TRACKS_FOLDER + "/" + filename;
                Track track = new Track(path, "Track " + i, "By the Numbers", "Bobby");
                mTracks.add(track);

                try {
                    AssetFileDescriptor afd = mAssets.openFd(track.getPath());
                    int soundId = mSoundPool.load(afd, 1);
                    track.setId(soundId);
                }
                catch(IOException ioe) {
                    Log.e(TAG, "could not load sound from file: " + track.getPath(), ioe);
                }

                i = i + 1;
            }
        }
        catch(IOException ioe) {
            Log.e(TAG, "could not load sound files.", ioe);
        }
    }

    public void play(Track track) {
        Integer id = track.getId();
        if(id != null) {
            mSoundPool.play(
                    id,   // sound id
                    1.0f, // left volume
                    1.0f, // right volume
                    1,    // priority (ignored)
                    0,    // loop counter, 0 for no loop
                    1.0f  // playback rate
            );
        }
    }

    public List<Track> getTracks() {
        return mTracks;
    }

    public void release() {
        mSoundPool.release();
    }
}
