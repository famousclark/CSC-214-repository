package mobappdev.lecture19.Themes;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobappdev.lecture19.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TheminFragment extends Fragment {


    public TheminFragment() {
        // Required empty public constructor
    }


    public static TheminFragment newInstance() {
        return new TheminFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_themin, container, false);
    }


}
