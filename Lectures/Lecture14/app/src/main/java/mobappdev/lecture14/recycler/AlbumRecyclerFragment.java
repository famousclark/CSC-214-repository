package mobappdev.lecture14.recycler;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mobappdev.lecture14.MainActivity;
import mobappdev.lecture14.R;
import mobappdev.lecture14.model.Album;
import mobappdev.lecture14.model.Collection;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumRecyclerFragment extends Fragment {

    private RecyclerView mRecyclerView;

    public AlbumRecyclerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_album_recycler, container, false);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_view_albums);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Album> albums = Collection.get().getAlbums();
        mRecyclerView.setAdapter(new AlbumAdapter(albums));

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_album_recycler_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled;
        switch(item.getItemId()) {
            case R.id.menu_main_activity:
                restartActivity(MainActivity.class);
                handled = true;
                break;
            case R.id.menu_list_view:
                restartActivity(MainActivity.class);
                handled = true;
                break;
            default:
                handled = super.onOptionsItemSelected(item);
                break;
        }

        return handled;
    }

    private void restartActivity(Class activityClass) {
        Intent intent = new Intent(getActivity(), activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}
