package mobappdev.lecture17.masterdetail;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mobappdev.lecture17.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    private static final String ARG_MESSAGE = "ARG_MESSAGE";
    private static final String ARG_BACKGROUND = "ARG_BACKGROUND";

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newFragment(CharSequence message, int background) {
        Bundle args = new Bundle();
        args.putCharSequence(ARG_MESSAGE, message);
        args.putInt(ARG_BACKGROUND, background);

        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        Bundle args = getArguments();
        CharSequence message = args.getCharSequence(ARG_MESSAGE);
        int background = args.getInt(ARG_BACKGROUND);
        TextView textViewDetail = (TextView)view.findViewById(R.id.text_view_detail);
        textViewDetail.setText(message);
        textViewDetail.setBackgroundColor(background);

        return view;
    }


}
