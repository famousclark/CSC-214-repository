package mobappdev.lecture17.masterdetail;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture17.R;

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_MESSAGE = "mobappdev.lecture17.masterdetail.extra.Message";
    private static final String EXTRA_BACKGROUND = "mobappdev.lecture17.masterdetail.extra.Background";

    public static Intent newInstance(Context parent, CharSequence message, int background) {
        Intent intent = new Intent(parent, DetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(EXTRA_BACKGROUND, background);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        CharSequence message = intent.getCharSequenceExtra(EXTRA_MESSAGE);
        int background = intent.getIntExtra(EXTRA_BACKGROUND, 0);

        DetailFragment fragment = DetailFragment.newFragment(message, background);

        FragmentManager manager = getFragmentManager();
        manager.beginTransaction()
                .add(R.id.frame_layout_detail, fragment)
                .commit();
    }
}
