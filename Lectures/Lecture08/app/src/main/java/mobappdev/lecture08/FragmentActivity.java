package mobappdev.lecture08;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class FragmentActivity extends Activity {

    private static final String TAG = "FragmentActivity";

    private Fragment mFirstFragment;
    private Fragment mSecondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        mFirstFragment = new FirstFragment();
        mSecondFragment = new SecondFragment();
    }

    public void firstFragment(View view) {
        Log.d(TAG, "firstFragment(View) called");
        if(mFirstFragment.isAdded() == false) {
            getFragmentManager()
                    .beginTransaction()
                    .remove(mSecondFragment) // safe to remove even if it's not added
                    .add(R.id.frame_layout_fragments, mFirstFragment)
                    .commit();
        }
    }

    public void secondFragment(View view) {
        Log.d(TAG, "secondFragment(View) called");
        if(mSecondFragment.isAdded() == false) {
            getFragmentManager()
                    .beginTransaction()
                    .remove(mFirstFragment) // safe to remove even if it's not added
                    .add(R.id.frame_layout_fragments, mSecondFragment)
                    .commit();
        }
    }
}
