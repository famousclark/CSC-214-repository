package mobappdev.lecture20.loopernetwork;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import mobappdev.lecture20.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LooperNetworkFragment extends Fragment {
    private static final String TAG = "LooperFragmentTag";
    private static final String IMAGE_URL = "https://www.google.com/images/nav_logo242.png";

    private ProgressBar mProgressBar;
    private Button mGetImages;
    private GetImageHandler mImagesHandler;
    private ToastHandlerThread mToastHandler;

    public LooperNetworkFragment() {
        // Required empty public constructor
    }

    public static LooperNetworkFragment newInstance() {
        return new LooperNetworkFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        Handler responseHandler = new Handler();

        mImagesHandler = new GetImageHandler(responseHandler);
        mImagesHandler.setDownloadProgressListener(new GetImageHandler.DownloadProgressListener() {
            @Override
            public void imagesDownloadedSoFar(int number) {
                mProgressBar.setProgress(number);
            }

            @Override
            public void downloadComplete() {
                mGetImages.setEnabled(true);
                Toast.makeText(getActivity(), R.string.message_finished, Toast.LENGTH_SHORT).show();
            }
        });
        mImagesHandler.start();
        mImagesHandler.getLooper(); // blocks until onLooperPrepared is called, which
                                    // avoids a potential (but unlikely) race condition
        Log.i(TAG, "Started image handler");


        mToastHandler = new ToastHandlerThread(responseHandler);
        mToastHandler.setToastListener(new ToastHandlerThread.ToastListener() {
            @Override
            public void toastReadyToPop(String message) {
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
        mToastHandler.start();
        mToastHandler.getLooper();
        Log.i(TAG, "Started toast handler");
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
                mGetImages.setEnabled(false);
                mImagesHandler.downloadImages(IMAGE_URL);
            }
        });

        final EditText message = (EditText)view.findViewById(R.id.edit_text_message);

        Button popToast = (Button)view.findViewById(R.id.button_toast);
        popToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToastHandler.popToast(message.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mImagesHandler.quit();
        Log.i(TAG, "Image handler thread destroyed.");
        mToastHandler.quit();
        Log.i(TAG, "Toast handler thread destroyed.");
    }
}
