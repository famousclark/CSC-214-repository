package mobappdev.lecture22.receiver;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;

import mobappdev.lecture22.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReceiverFragment extends Fragment {


    public ReceiverFragment() {
        // Required empty public constructor
    }

    public static ReceiverFragment newInstance() {
        return new ReceiverFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receiver, container, false);

        long timestamp = Prefs.getBootTime(getActivity());
        Date boot = new Date(timestamp);

        TextView bootDate = (TextView)view.findViewById(R.id.text_view_boot_date);
        bootDate.setText(DateFormat.getLongDateFormat(getActivity()).format(boot));

        TextView bootTime = (TextView)view.findViewById(R.id.text_view_boot_time);
        bootTime.setText(DateFormat.getTimeFormat(getActivity()).format(boot));

        return view;
    }

}
