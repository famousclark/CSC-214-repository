package mobappdev.lecture23;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mobappdev.lecture23.paintr.PaintrActivity;
import mobappdev.lecture23.talktomyself.TalkToMyselfActivity;
import mobappdev.lecture23.whispershout.WhisperShoutActivity;


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

        Button whisperOrShout = (Button)view.findViewById(R.id.button_whisper_shout);
        whisperOrShout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(WhisperShoutActivity.newIntent(getActivity()));
            }
        });

        Button orderedReceivers = (Button)view.findViewById(R.id.button_ordered_receivers);
        orderedReceivers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(TalkToMyselfActivity.newIntent(getActivity()));
            }
        });

        Button paintR = (Button)view.findViewById(R.id.button_paintr);
        paintR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(PaintrActivity.newIntent(getActivity()));
            }
        });

        return view;
    }

}
