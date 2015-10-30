package mobappdev.lecture16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import mobappdev.lecture16.camera.CameraActivity;

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
        switch (item.getItemId()) {
            case R.id.menu_item_browse_to:
                startActivity(BrowseToActivity.newIntent(this));
                handled = true;
                break;
            case R.id.menu_item_photo:
                Intent intent = CameraActivity.newIntent(this);
                startActivity(intent);
                handled = true;
                break;
            case R.id.menu_item_contacts:
                startActivity(ContactsActivity.newIntent(this));
                handled = true;
                break;
            case R.id.menu_item_phone:
                startActivity(DialPhoneActivity.newIntent(this));
                handled = true;
                break;
            default:
                handled = super.onOptionsItemSelected(item);
                break;
        }

        return handled;
    }
}
