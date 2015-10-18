package mobappdev.lecture14.listview;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import mobappdev.lecture14.model.Album;
import mobappdev.lecture14.model.Collection;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumList extends ListFragment {

    private List<Album> mAlbums;

    public AlbumList() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAlbums = Collection.get().getAlbums();

        AlbumArrayAdapter adapter = new AlbumArrayAdapter(getContext(), mAlbums);
        setListAdapter(adapter);
    }

//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//
//        FragmentManager manager = getFragmentManager();
//        AlbumDialog dialog = new AlbumDialog();
//        dialog.show(manager, "Album Dialog");
//    }
}
