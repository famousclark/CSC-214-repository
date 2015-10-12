package mobappdev.lecture12.recyclerview;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobappdev.lecture12.R;
import mobappdev.lecture12.model.Collection;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComicRecyclerViewFragment extends Fragment {

    private RecyclerView mRecyclerView;

    public ComicRecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_comic_recycler_view, container, false);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_view_comics);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ComicAdapter adapter = new ComicAdapter(Collection.get(getActivity()).getCollection());
        mRecyclerView.setAdapter(adapter);

        return view;
    }


}
