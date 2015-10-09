package mobappdev.lecture12.listview;


import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import mobappdev.lecture12.R;
import mobappdev.lecture12.model.Collection;
import mobappdev.lecture12.model.Comic;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComicListFragment extends ListFragment {

    private List<Comic> mComics;

    public ComicListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.title_comic_collection);
        mComics = Collection.get(getActivity()).getCollection();

        ArrayAdapter<Comic> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, mComics);
        setListAdapter(adapter);
    }
}
