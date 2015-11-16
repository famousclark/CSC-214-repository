package mobappdev.lecture19.styles;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture19.R;

public class StylinActivity extends AppCompatActivity {

    public static Intent newIntent(Context c) {
        Intent i = new Intent(c, StylinActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stylin);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.frame_layout_stylin);
        if(fragment == null) {
            fragment = StylinFragment.newInstance();
            manager.beginTransaction()
                    .add(R.id.frame_layout_stylin, fragment)
                    .commit();
        }
    }
}
