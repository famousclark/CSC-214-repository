package mobappdev.lecture20.badnetwork;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import mobappdev.lecture20.HttpHelper;
import mobappdev.lecture20.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BadNetworkFragment extends Fragment {

    private static final String TAG = "BadNetworkFragmentTag";

    public BadNetworkFragment() {
        // Required empty public constructor
    }

    public static BadNetworkFragment newInstance() {
        return new BadNetworkFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bad_network, container, false);

        final EditText url = (EditText)view.findViewById(R.id.edit_text_url);
        final TextView message = (TextView)view.findViewById(R.id.text_view_output);
        Button blowUp = (Button)view.findViewById(R.id.button_blow_up);
        blowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String string = new HttpHelper().getString(url.getText().toString());
                    message.setText(string.substring(0, 100));
                }
                catch(IOException ioe) {
                    Toast.makeText(getContext(), "Failed to fetch URL!", Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Failed to fetch URL", ioe);
                }
            }
        });

        return view;
    }


}
