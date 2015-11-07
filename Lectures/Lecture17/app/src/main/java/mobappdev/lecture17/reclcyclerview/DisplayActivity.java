package mobappdev.lecture17.reclcyclerview;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture17.R;

public class DisplayActivity extends AppCompatActivity {

    private static final String EXTRA_MESSAGE = "mobappdev.lecture17.recyclerview.extras.Message";

    public static Intent newIntent(Context c, CharSequence message) {
        Intent intent = new Intent(c, DisplayActivity.class);

        intent.putExtra(EXTRA_MESSAGE, message);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        CharSequence message = getIntent().getCharSequenceExtra(EXTRA_MESSAGE);

        FragmentManager manager = getFragmentManager();
        manager.beginTransaction()
                .add(R.id.frame_layout_display, DisplayFragment.newInstance(message))
                .commit();

    }
}
