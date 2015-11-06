package mobappdev.lecture17.simplemaster;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture17.R;

public class SimpleDetailActivity extends AppCompatActivity {

    public static Intent newIntent(Context c, CharSequence display, int background) {
        Intent intent = new Intent(c, SimpleDetailActivity.class);
        intent.putExtra(SimpleDetailFragment.ARG_DISPLAY, display);
        intent.putExtra(SimpleDetailFragment.ARG_BACKGROUND, background);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_detail);

        Intent intent = getIntent();

        SimpleDetailFragment fragment = new SimpleDetailFragment();
        fragment.setArguments(intent.getExtras());

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.frame_layout_simple_detail, fragment)
                .commit();
    }
}
