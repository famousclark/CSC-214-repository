package mobappdev.lecture14;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import mobappdev.lecture14.listview.AlbumListActivity;
import mobappdev.lecture14.recycler.AlbumRecyclerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                startAlbumListActivity();
                handled = true;
                break;
            case R.id.menu_recycler_view:
                startAlbumRecyclerActivity();
                handled = true;
                break;
            default:
                handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }

    private void startAlbumListActivity() {
        Intent intent = new Intent(this, AlbumListActivity.class);
        startActivity(intent);
    }

    private void startAlbumRecyclerActivity() {
        Intent intent = new Intent(this, AlbumRecyclerActivity.class);
        startActivity(intent);
    }
}
