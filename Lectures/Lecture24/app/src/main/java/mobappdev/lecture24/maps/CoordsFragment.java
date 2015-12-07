package mobappdev.lecture24.maps;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mobappdev.lecture24.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoordsFragment extends Fragment {
    private static final String TAG = "CoordsFragmentTag";

    public interface OnCoordinatesChangedListener {
        public void onCoordinatesChanged(double lat, double lon);
    }

    private OnCoordinatesChangedListener mListener;
    private EditText etLat;
    private EditText etLon;

    public CoordsFragment() {
        // Required empty public constructor
    }

    public static CoordsFragment newInstance() {
        return new CoordsFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnCoordinatesChangedListener)context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (OnCoordinatesChangedListener)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coords, container, false);

        etLat = (EditText)view.findViewById(R.id.et_latitude);
        etLat.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                etLat.setNextFocusDownId(etLon.getId());
                return true;
            }
        });

        etLon = (EditText)view.findViewById(R.id.et_longitude);
        etLon.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled;
                try {
                    double lat = Double.parseDouble(etLat.getText().toString());
                    double lon = Double.parseDouble(etLon.getText().toString());
                    mListener.onCoordinatesChanged(lat, lon);
                    handled = true;
                }
                catch(NumberFormatException nfe) {
                    Log.e(TAG, "Invalid latitude and longitude; must be decimals.", nfe);
                    Toast.makeText(getActivity(), R.string.error_lat_lon,
                            Toast.LENGTH_SHORT).show();
                    handled = false;
                }
                return handled;
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
