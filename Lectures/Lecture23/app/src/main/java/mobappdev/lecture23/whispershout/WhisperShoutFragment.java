package mobappdev.lecture23.whispershout;


import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import mobappdev.lecture23.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WhisperShoutFragment extends Fragment {
    static final String PERMISSION_WHISPER = "mobappdev.lecture23.WHISPER";
    static final String EXTRA_SHOUT = "mobappdev.lecture23.extra.SHOUT";
    static final String EXTRA_WHISPER = "mobappdev.lecture23.extra.WHISPER";
    static final String ACTION_SHOUT = "mobappdev.lecture23.action.SHOUT";
    static final String ACTION_WHISPER = "mobappdev.lecture23.action.WHISPER";

    private ShoutReceiver mShoutReceiver;
    private WhisperReceiver mWhisperReceiver;

    public WhisperShoutFragment() {
        // Required empty public constructor
    }

    public static WhisperShoutFragment newInstance() {
        return new WhisperShoutFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_whisper_shout, container, false);

        mShoutReceiver = new ShoutReceiver();
        mWhisperReceiver = new WhisperReceiver();

        final EditText etShout = (EditText)view.findViewById(R.id.et_shout);
        Button shout = (Button)view.findViewById(R.id.button_shout);
        shout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_SHOUT);
                intent.putExtra(EXTRA_SHOUT, etShout.getText().toString());
                getActivity().sendBroadcast(intent);
            }
        });

        final EditText etWhisper = (EditText)view.findViewById(R.id.et_whisper);
        Button whisper = (Button)view.findViewById(R.id.button_whisper);
        whisper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_WHISPER);
                intent.putExtra(EXTRA_WHISPER, etWhisper.getText().toString());
                getActivity().sendBroadcast(intent, PERMISSION_WHISPER);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        getActivity().registerReceiver(mShoutReceiver, mShoutReceiver.getIntentFilter());
        getActivity().registerReceiver(mWhisperReceiver, mWhisperReceiver.getIntentFilter(),
                PERMISSION_WHISPER, null);
    }
}
