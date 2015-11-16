package mobappdev.lecture19.styles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobappdev.lecture19.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StylinFragment extends Fragment {


    public StylinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stylin, container, false);
    }


    public static StylinFragment newInstance() {
        return new StylinFragment();
    }
}
