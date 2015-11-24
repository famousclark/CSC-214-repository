package mobappdev.lecture21;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mobappdev.lecture21.mediaplayer.MediaPlayerActivity;
import mobappdev.lecture21.reminder.ReminderActivity;
import mobappdev.lecture21.sharedprefs.SharedPrefsActivity;


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

        Button mediaPlayer = (Button)view.findViewById(R.id.button_media_player);
        mediaPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MediaPlayerActivity.newIntent(getActivity()));
            }
        });

        Button sharedPrefs = (Button)view.findViewById(R.id.button_shared_prefs);
        sharedPrefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SharedPrefsActivity.newIntent(getActivity()));
            }
        });

        Button reminder = (Button)view.findViewById(R.id.button_reminder);
        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ReminderActivity.newIntent(getActivity()));
            }
        });


        return view;
    }


}
