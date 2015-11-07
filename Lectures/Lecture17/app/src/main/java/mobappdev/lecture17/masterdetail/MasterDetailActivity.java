package mobappdev.lecture17.masterdetail;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture17.R;

public class MasterDetailActivity extends AppCompatActivity
        implements MasterFragment.DetailItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);

        MasterFragment fragment = new MasterFragment();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction()
                .add(R.id.frame_layout_master, fragment)
                .commit();
    }

    @Override
    public void OnDetailItemClick(CharSequence text, int background) {
        if(findViewById(R.id.frame_layout_detail) == null) {
            startActivity(DetailActivity.newInstance(this, text, background));
        }
        else {
            DetailFragment fragment = DetailFragment.newFragment(text, background);
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.frame_layout_detail, fragment)
                    .commit();
        }
    }
}
