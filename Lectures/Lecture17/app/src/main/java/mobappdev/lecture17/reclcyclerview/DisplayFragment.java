package mobappdev.lecture17.reclcyclerview;


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
public class DisplayFragment extends Fragment {


    private static final String ARG_MESSAGE = "ARG_MESSAGE";

    public DisplayFragment() {
        // Required empty public constructor
    }

    public static DisplayFragment newInstance(CharSequence message) {
        DisplayFragment fragment = new DisplayFragment();

        Bundle args = new Bundle();
        args.putCharSequence(ARG_MESSAGE, message);
        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        TextView textViewMessage = (TextView)view.findViewById(R.id.text_view_display);
        Bundle args = getArguments();
        CharSequence message = args.getCharSequence(ARG_MESSAGE);
        textViewMessage.setText(message);

        return view;
    }


}
