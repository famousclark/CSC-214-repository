package mobappdev.lecture14.listview;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import mobappdev.lecture14.dialog.AlbumDialog;
import mobappdev.lecture14.model.Album;
import mobappdev.lecture14.model.Collection;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumListFragment extends ListFragment {

    private List<Album> mAlbums;

    public AlbumListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAlbums = Collection.get().getAlbums();

        AlbumArrayAdapter adapter = new AlbumArrayAdapter(getContext(), mAlbums);
        setListAdapter(adapter);

        // this causes an illegal state exception: content view not yet created
        //getListView().setOnItemClickListener(new ItemClickListener());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        // this causes an illegal state exception: content view not yet created
        getListView().setOnItemClickListener(new ItemClickListener());
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        // this seems to work
        //getListView().setOnItemClickListener(new ItemClickListener());
    }

    @Override
    public void onResume() {
        super.onResume();
        // this also seems to work
        //getListView().setOnItemClickListener(new ItemClickListener());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        FragmentManager manager = getFragmentManager();
        AlbumDialog dialog = AlbumDialog.newInstance(mAlbums.get(position));
        dialog.show(manager, "Album Dialog");
    }

    private class ItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getContext(), "Item Clicked!", Toast.LENGTH_SHORT).show();
        }
    }
}
