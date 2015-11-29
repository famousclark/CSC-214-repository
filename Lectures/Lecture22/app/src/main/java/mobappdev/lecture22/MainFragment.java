package mobappdev.lecture22;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mobappdev.lecture22.bowser.WebBowserActivity;
import mobappdev.lecture22.receiver.ReceiverActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button receivers = (Button)view.findViewById(R.id.button_receivers);
        receivers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ReceiverActivity.newIntent(getActivity()));
            }
        });

        Button bowser = (Button)view.findViewById(R.id.button_web_bowser);
        bowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(WebBowserActivity.newIntent(getActivity()));
            }
        });

        return view;
    }

}
