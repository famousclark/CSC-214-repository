package mobappdev.lecture14.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import mobappdev.homework06.R;
import mobappdev.homework06.model.Album;

/**
 * Created by Bobby on 10/18/2015.
 */
public class AlbumArrayAdapter extends ArrayAdapter<Album> {
    private List<Album> mAlbums;

    public AlbumArrayAdapter(Context context, List<Album> albums) {
        super(context, 0, albums);
        this.mAlbums = albums;


    }



    @Override
    public View getView(int position, View layout, ViewGroup parent) {
        if(layout == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            layout = inflater.inflate(R.layout.view_album, parent, false);
        }

        Album album = mAlbums.get(position);
        TextView name = (TextView)layout.findViewById(R.id.text_view_name);
        name.setText(album.getName());
        TextView artist = (TextView)layout.findViewById(R.id.text_view_artist);
        artist.setText(album.getArtist());
        TextView genre = (TextView)layout.findViewById(R.id.text_view_genre);
        genre.setText(album.getGenre());
        TextView tracks = (TextView)layout.findViewById(R.id.text_view_tracks);
        tracks.setText(Integer.toString(album.getTrackCount()));

        return layout;
    }
}
