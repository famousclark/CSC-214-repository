package mobappdev.lecture20.serialnetwork;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;

import mobappdev.lecture20.HttpHelper;
import mobappdev.lecture20.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SerialNetworkFragment extends Fragment {
    private static final String TAG = "SerialNetworkFragTag";
    private static final String IMAGE_URL = "https://www.google.com/images/nav_logo242.png";

    private ProgressBar mProgressBar;
    private Button mGetImages;

    public SerialNetworkFragment() {
        // Required empty public constructor
    }

    public static SerialNetworkFragment newInstance() {
        return new SerialNetworkFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_serial_network, container, false);

        mProgressBar = (ProgressBar)view.findViewById(R.id.progress_bar_download_task);
        mProgressBar.setMax(100);

        mGetImages = (Button)view.findViewById(R.id.button_get_images);
        mGetImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetImages.setEnabled(false);
                new BigDownloadTask().execute(IMAGE_URL);
            }
        });

        final EditText message = (EditText)view.findViewById(R.id.edit_text_message);

        Button popToast = (Button)view.findViewById(R.id.button_toast);
        popToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ToastTask().execute(message.getText().toString());
            }
        });

        return view;
    }

    private class BigDownloadTask extends AsyncTask<String,Integer,Void> {

        @Override
        protected Void doInBackground(String... params) {
            String imageUrl = params[0];
            HttpHelper helper = new HttpHelper();
            boolean success = true;
            for(int i=0; success && i<100; i++) {
                try {
                    helper.getBytes(imageUrl);
                    publishProgress(i+1);
                }
                catch(IOException ioe) {
                    Log.e(TAG, "Failed to fetch image!", ioe);
                    success = false;
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mProgressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mGetImages.setEnabled(true);
            Toast.makeText(getActivity(), R.string.message_finished, Toast.LENGTH_SHORT).show();
        }
    }

    private class ToastTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... params) {
            return params[0];
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();
        }
    }

}
