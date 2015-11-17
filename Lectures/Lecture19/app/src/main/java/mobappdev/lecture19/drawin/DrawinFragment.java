package mobappdev.lecture19.drawin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobappdev.lecture19.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrawinFragment extends Fragment {


    public DrawinFragment() {
        // Required empty public constructor
    }

    public static DrawinFragment newInstance() {
        return new DrawinFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drawin, container, false);
    }


}
