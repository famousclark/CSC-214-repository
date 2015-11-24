package mobappdev.lecture21.sharedprefs;


import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import mobappdev.lecture21.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SharedPrefsFragment extends Fragment {

    private static final String PREF_MESSAGE = "PREF_MESSAGE";
    private static final java.lang.String STATE_MESSAGE = "STATE_MESSAGE";
    private String mPrefsString;
    private EditText mSharedPrefs;
    private String mBundleString;
    private EditText mBundleState;


    public SharedPrefsFragment() {
        // Required empty public constructor
    }

    public static SharedPrefsFragment newInstance() {
        return new SharedPrefsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null) {
            mBundleString = savedInstanceState.getString(STATE_MESSAGE);
        }

        mPrefsString = PreferenceManager.getDefaultSharedPreferences(getActivity())
                .getString(PREF_MESSAGE, null);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shared_prefs, container, false);

        mSharedPrefs = (EditText)view.findViewById(R.id.edit_text_shared_prefs);
        if(mPrefsString !=null) {
            mSharedPrefs.setText(mPrefsString);
        }

        mBundleState = (EditText)view.findViewById(R.id.edit_text_bundle_state);
        if(mBundleString != null) {
            mBundleState.setText(mBundleString);
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_MESSAGE, mBundleState.getText().toString());
    }

    @Override
    public void onPause() {
        super.onPause();

        PreferenceManager.getDefaultSharedPreferences(getActivity())
                .edit()
                .putString(PREF_MESSAGE, mSharedPrefs.getText().toString())
                .apply();
    }
}
