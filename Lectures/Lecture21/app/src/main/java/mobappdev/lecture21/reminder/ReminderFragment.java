package mobappdev.lecture21.reminder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mobappdev.lecture21.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReminderFragment extends Fragment {

    private EditText minutes;
    private EditText message;

    public ReminderFragment() {
        // Required empty public constructor
    }

    public static ReminderFragment newInstance() {
        return new ReminderFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reminder, container, false);

        minutes = (EditText)view.findViewById(R.id.edit_text_time);
        message = (EditText)view.findViewById(R.id.edit_text_message);

        Button reminder = (Button)view.findViewById(R.id.button_create_reminder);
        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = message.getText().toString();
                int mins = Integer.parseInt(minutes.getText().toString());

                ReminderService.newReminder(getActivity(), msg, mins);
                Toast.makeText(getActivity(), R.string.toast_reminder, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }



}
