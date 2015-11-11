package mobappdev.lecture18;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrackListFragment extends Fragment {

    private static final String TAG = "TrackListFragmentLog";
    private Radio mRadio;

    public TrackListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate() called");
        setRetainInstance(true);
        mRadio = new Radio(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView() called");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_track_list, container, false);

        RecyclerView recycler = (RecyclerView)view.findViewById(R.id.recycler_view_track_list);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new TrackAdapter(mRadio.getTracks()));

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() called");
        mRadio.release();
    }

    private class TrackHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTrackName;
        private TextView mAlbumName;
        private TextView mArtistName;
        private Track mTrack;

        public TrackHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.view_track, container, false));

            mTrackName = (TextView)itemView.findViewById(R.id.text_view_track_name);
            mAlbumName = (TextView)itemView.findViewById(R.id.text_view_album);
            mArtistName = (TextView)itemView.findViewById(R.id.text_view_artist);

            itemView.setOnClickListener(this);
        }

        public void bind(Track track) {
            mTrack = track;
            mTrackName.setText(track.getName());
            mAlbumName.setText(track.getAlbum());
            mArtistName.setText(track.getArtist());
        }

        @Override
        public void onClick(View v) {
            mRadio.play(mTrack);
        }
    }

    private class TrackAdapter extends RecyclerView.Adapter<TrackHolder> {
        private List<Track> mTracks;

        public TrackAdapter(List<Track> tracks) {
            mTracks = tracks;
        }

        @Override
        public TrackHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            return new TrackHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(TrackHolder holder, int position) {
            holder.bind(mTracks.get(position));
        }

        @Override
        public int getItemCount() {
            return mTracks.size();
        }
    }
}
