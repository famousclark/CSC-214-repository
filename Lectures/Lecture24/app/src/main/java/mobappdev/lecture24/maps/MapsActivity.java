package mobappdev.lecture24.maps;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;

import mobappdev.lecture24.Fragtivity;
import mobappdev.lecture24.R;

public class MapsActivity extends AppCompatActivity implements
        CoordsFragment.OnCoordinatesChangedListener {

    private MapsFragment mMapsFragment;

    public static Intent newIntent(Context context) {
        return new Intent(context, MapsActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        FragmentManager manager = getSupportFragmentManager();

        if(manager.findFragmentById(R.id.fl_coords_container) == null) {
            manager.beginTransaction()
                    .add(R.id.fl_coords_container, CoordsFragment.newInstance())
                    .commit();
        }

        mMapsFragment = (MapsFragment)manager.findFragmentById(R.id.fl_maps_container);
        if(mMapsFragment == null) {
            mMapsFragment = MapsFragment.newInstance();
            manager.beginTransaction()
                    .add(R.id.fl_maps_container, mMapsFragment)
                    .commit();
        }

        SeekBar zoomBar = (SeekBar)findViewById(R.id.zoombar);
        int max = (int)(MapsFragment.MAXIMUM_ZOOM - MapsFragment.MINIMUM_ZOOM);
        zoomBar.setMax(max);
        zoomBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mMapsFragment.updateZoom(progress + MapsFragment.MINIMUM_ZOOM);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.fragment_maps, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled;
        switch(item.getItemId()) {
            case R.id.mi_current_location:
                mMapsFragment.updateToCurrentLocation();
                handled = true;
                break;
            default:
                handled = super.onOptionsItemSelected(item);
                break;
        }
        return handled;
    }

    @Override
    public void onCoordinatesChanged(double lat, double lon) {
        // call mMapsFragment to update location
        mMapsFragment.updateLocation(lat, lon);
    }
}
