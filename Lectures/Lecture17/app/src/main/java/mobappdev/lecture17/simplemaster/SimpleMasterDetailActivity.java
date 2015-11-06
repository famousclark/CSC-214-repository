package mobappdev.lecture17.simplemaster;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture17.R;

public class SimpleMasterDetailActivity extends AppCompatActivity implements SimpleMasterFragment.SimpleItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_master_detail);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.frame_layout_simple_master_detail, new SimpleMasterFragment())
                .commit();
    }

    @Override
    public void simpleItemClicked(CharSequence display, int background) {
        startActivity(SimpleDetailActivity.newIntent(this, display, background));
    }
}
