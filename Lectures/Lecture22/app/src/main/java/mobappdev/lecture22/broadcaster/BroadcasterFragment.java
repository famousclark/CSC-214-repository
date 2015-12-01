package mobappdev.lecture22.broadcaster;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mobappdev.lecture22.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BroadcasterFragment extends Fragment {


    public BroadcasterFragment() {
        // Required empty public constructor
    }

    public static BroadcasterFragment newInstance() {
        return new BroadcasterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

}
