package mobappdev.lecture17.simplemaster;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mobappdev.lecture17.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleDetailFragment extends Fragment {
    
    public static final String ARG_DISPLAY = "ARG_DISPLAY";
    public static final String ARG_BACKGROUND = "ARG_BACKGROUND";

    public SimpleDetailFragment() {
        // Required empty public constructor
    }

    public static SimpleDetailFragment newInstance(CharSequence display, int background) {
        Bundle args = new Bundle();
        args.putCharSequence(ARG_DISPLAY, display);
        args.putInt(ARG_BACKGROUND, background);
        SimpleDetailFragment fragment = new SimpleDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_detail, container, false);

        Bundle args = getArguments();
        if(args != null) {
            CharSequence message = args.getCharSequence(ARG_DISPLAY);
            TextView display = (TextView) view.findViewById(R.id.text_view_simple);
            display.setText(message);

            int background = args.getInt(ARG_BACKGROUND);
            view.setBackgroundColor(background);
        }

        return view;
    }


}
