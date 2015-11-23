package mobappdev.lecture21.mediaplayer;


import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mobappdev.lecture21.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MediaPlayerFragment extends Fragment {
    private static final String TAG = "MediaPlayerFragTag";
    private static final String DIR_MUSIC = "music";

    private MediaPlayer mPlayer;
    private AssetManager mAssets;
    private RecyclerView mMusicList;
    private ImageButton mPause;

    public MediaPlayerFragment() {
        // Required empty public constructor
    }

    public static MediaPlayerFragment newInstance() {
        return new MediaPlayerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);  // audio playback continuity
        mAssets = getActivity().getAssets();
        mPlayer = new MediaPlayer();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i(TAG, "Media player is prepared...starting.");
                mPlayer.start();
                mPause.setImageResource(R.drawable.ic_pause);
                mPause.setEnabled(true);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_media_player, container, false);

        List<Music> music = new ArrayList<>();
        try {
            String[] musicNames = mAssets.list(DIR_MUSIC);
            for(String filename : musicNames) {
                String path = DIR_MUSIC + "/" + filename;
                music.add(new Music(filename, path));
            }
        }
        catch (IOException ioe) {
            Log.e(TAG, "Failed to load music!", ioe);
        }

        mMusicList = (RecyclerView)view.findViewById(R.id.recycler_view_music);
        mMusicList.setLayoutManager(new LinearLayoutManager(getContext()));
        mMusicList.setAdapter(new MusicAdapter(music));

        mPause = (ImageButton)view.findViewById(R.id.button_pause);
        mPause.setEnabled(false);
        mPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPlayer.isPlaying()) {
                    mPlayer.pause();
                    mPause.setImageResource(R.drawable.ic_play);
                }
                else {
                    mPlayer.start();
                    mPause.setImageResource(R.drawable.ic_pause);
                }
            }
        });

        return view;
    }

    private void play(Music music) {
        try {
            AssetManager assets = getActivity().getAssets();
            AssetFileDescriptor afd = assets.openFd(music.getPath());
            if(mPlayer.isPlaying()) {
                Log.i(TAG, "Media player is playing; stopping.");
                mPlayer.stop();
            }
            mPlayer.reset();
            Log.i(TAG, "Setting media player data source: " + music.getName());
            mPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mPlayer.prepare();
        }
        catch(IOException ioe) {
            Log.e(TAG, "Failed to play music: " + music.getPath());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.release();
        mPlayer = null;
    }

    private class MusicHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        private Music mMusic;

        public MusicHolder(View itemView) {
            super(itemView);
            mTextView = (TextView)itemView;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // do something
                    play(mMusic);
                }
            });
        }

        public void bind(Music music) {
            mMusic = music;
            mTextView.setText(music.getName());
        }
    }

    private class MusicAdapter extends RecyclerView.Adapter<MusicHolder> {
        private List<Music> mMusic;

        public MusicAdapter(List<Music> music) {
            mMusic = music;
        }

        @Override
        public MusicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.view_music, parent, false);
            return new MusicHolder(view);
        }

        @Override
        public void onBindViewHolder(MusicHolder holder, int position) {
            holder.bind(mMusic.get(position));
        }

        @Override
        public int getItemCount() {
            return mMusic.size();
        }
    }
}
