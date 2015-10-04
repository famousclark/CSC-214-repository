package mobappdev.lecture09;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoggingFragment extends Fragment {
    protected final String TAG = getClass().getName();

    public LoggingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach(Context) called." );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView(LayoutInflater,ViewGroup,Bundle) called." );
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate(Bundle) called.");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated(Bundle) called.");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() called.");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() called.");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState(Bundle) called.");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() called.");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() called.");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView() called.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() called.");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach() called.");
    }
}
