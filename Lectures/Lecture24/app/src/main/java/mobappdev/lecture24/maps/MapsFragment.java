package mobappdev.lecture24.maps;


import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import mobappdev.lecture24.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapsFragment extends SupportMapFragment {
    private static final String TAG = "MapsFragmentTag";
    public static final float MINIMUM_ZOOM = 2.0f;
    public static final float MAXIMUM_ZOOM = 21.0f;
    private GoogleApiClient mClient;
    private GoogleMap mMap;

    private double mLat;
    private double mLon;
    private float mZoom;

    public MapsFragment() {
        // Required empty public constructor
    }

    public static MapsFragment newInstance() {
        return new MapsFragment();
    }

    public void updateLocation(double lat, double lon) {
        mLat = lat;
        mLon = lon;
        updateDisplay();
    }

    public void updateToCurrentLocation() {
        Log.i(TAG, "Should find image...");
        LocationRequest request = LocationRequest.create();
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        request.setNumUpdates(1);
        request.setInterval(0);

        LocationServices.FusedLocationApi
                .requestLocationUpdates(mClient, request, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        Log.i(TAG, "Got a fix: " + location);
                        updateLocation(location.getLatitude(), location.getLongitude());
                    }
                });
    }

    public void updateZoom(float zoom) {
        mZoom = zoom;
        updateDisplay();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mZoom = MINIMUM_ZOOM;

        mClient = new GoogleApiClient.Builder(getActivity())
                .addApi(LocationServices.API)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(Bundle bundle) {

                    }

                    @Override
                    public void onConnectionSuspended(int i) {

                    }
                })
                .build();

        getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mClient.connect();
    }

    @Override
    public void onStop() {
        super.onStop();
        mClient.disconnect();
    }

    // SupportMapFragment has its own onCreateView method that is used to create and display a map
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_maps, container, false);
//    }

    private void updateDisplay() {
        if(mMap != null) {
            LatLng location = new LatLng(mLat, mLon);
            MarkerOptions locationMarker = new MarkerOptions().position(location);

            mMap.clear();
            mMap.addMarker(locationMarker);

            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(location, mZoom);
            mMap.animateCamera(update);
        }
    }

}
