package mobappdev.lecture14.recycler;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import mobappdev.lecture14.R;
import mobappdev.lecture14.dialog.AlbumDialog;
import mobappdev.lecture14.model.Album;

/**
 * Created by Bobby on 10/18/2015.
 */
public class AlbumHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "AlbumHolder";

    private TextView mName;
    private TextView mArtist;
    private TextView mGenre;
    private TextView mTracks;
    private Album mAlbum;

    public AlbumHolder(View itemView) {
        super(itemView);

        mName = (TextView)itemView.findViewById(R.id.text_view_name);
        mArtist = (TextView)itemView.findViewById(R.id.text_view_artist);
        mGenre = (TextView)itemView.findViewById(R.id.text_view_genre);
        mTracks = (TextView)itemView.findViewById(R.id.text_view_tracks);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity c = (AppCompatActivity)v.getContext();
                FragmentManager manager = c.getSupportFragmentManager();
                AlbumDialog dialog = AlbumDialog.newInstance(mAlbum);
                dialog.show(manager, "AlbumDialog");
            }
        });
    }

    public void bind(Album album) {
        mAlbum = album;
        mName.setText(album.getName());
        mArtist.setText(album.getArtist());
        mGenre.setText(album.getGenre());
        mTracks.setText(Integer.toString(album.getTrackCount()));
    }
}
