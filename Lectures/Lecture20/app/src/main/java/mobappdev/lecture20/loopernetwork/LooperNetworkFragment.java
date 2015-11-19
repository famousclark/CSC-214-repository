package mobappdev.lecture20.loopernetwork;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import mobappdev.lecture20.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LooperNetworkFragment extends Fragment {

    private ProgressBar mProgressBar;
    private Button mGetImages;

    public LooperNetworkFragment() {
        // Required empty public constructor
    }

    public static LooperNetworkFragment newInstance() {
        return new LooperNetworkFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_looper_network, container, false);

        mProgressBar = (ProgressBar)view.findViewById(R.id.progress_bar_download_task);
        mProgressBar.setMax(100);

        mGetImages = (Button)view.findViewById(R.id.button_get_images);
        mGetImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get images looper
            }
        });

        final EditText message = (EditText)view.findViewById(R.id.edit_text_message);

        Button popToast = (Button)view.findViewById(R.id.button_toast);
        popToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // toast looper
            }
        });

        return view;
    }


}
