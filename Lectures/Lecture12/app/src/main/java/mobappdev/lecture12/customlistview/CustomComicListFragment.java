package mobappdev.lecture12.customlistview;


import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mobappdev.lecture12.R;
import mobappdev.lecture12.model.Collection;
import mobappdev.lecture12.model.Comic;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomComicListFragment extends ListFragment {
    private List<Comic> mComics;

    public CustomComicListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Custom Comic List");
        mComics = Collection.get(getActivity()).getCollection();

        ComicArrayAdapter<Comic> adapter = new ComicArrayAdapter<>(getActivity(), 0, mComics);
        setListAdapter(adapter);
    }
}
