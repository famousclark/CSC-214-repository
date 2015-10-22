package mobappdev.lecture14;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import mobappdev.lecture14.listview.AlbumListActivity;
import mobappdev.lecture14.recycler.AlbumRecyclerActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // purposely leaving the default title here for exemplary purposes.  switching to an
        // activity that sets the title and then back shows that changing the title in one
        // activity doesn't affect other activities
        ActionBar aBar = getSupportActionBar();
        aBar.setSubtitle(getString(R.string.subtitle_main_activity));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled;
        switch(item.getItemId()) {
            case R.id.menu_list_view:
                restartActivity(AlbumListActivity.class);
                handled = true;
                break;
            case R.id.menu_recycler_view:
                restartActivity(AlbumRecyclerActivity.class);
                handled = true;
                break;
            default:
                handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    private void restartActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}
