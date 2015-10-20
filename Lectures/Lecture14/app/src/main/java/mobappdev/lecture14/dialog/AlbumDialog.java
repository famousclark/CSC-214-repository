package mobappdev.lecture14.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import mobappdev.lecture14.R;
import mobappdev.lecture14.model.Album;


/**
 * Created by Bobby on 10/18/2015.
 */
public class AlbumDialog extends DialogFragment {
    private static final String KEY_NAME = "NAME";
    private static final String KEY_ARTIST = "ARTIST";
    private static final String KEY_GENRE = "GENRE";
    private static final String KEY_TRACKS = "TRACKS";

    public AlbumDialog() {

    }

    public static AlbumDialog newInstance(Album album) {
        Bundle args = new Bundle();
        args.putString(KEY_NAME, album.getName());
        args.putString(KEY_ARTIST, album.getArtist());
        args.putString(KEY_GENRE, album.getGenre());
        args.putInt(KEY_TRACKS, album.getTrackCount());
        AlbumDialog dialog = new AlbumDialog();
        dialog.setArguments(args);
        return dialog;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.view_album, null);
        Bundle args = getArguments();
        if(args != null) {
            setText(view, R.id.text_view_name, args.getString(KEY_NAME));
            setText(view, R.id.text_view_artist, args.getString(KEY_ARTIST));
            setText(view, R.id.text_view_genre, args.getString(KEY_GENRE));
            setText(view, R.id.text_view_tracks, Integer.toString(args.getInt(KEY_TRACKS)));
        }

        return new AlertDialog.Builder(getContext())
                .setTitle(getString(R.string.title_album_dialog))
                .setView(view)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }

    private static void setText(View view, int id, CharSequence text) {
        TextView textView = (TextView)view.findViewById(id);
        textView.setText(text);
    }
}
