package mobappdev.lecture19.drawin;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture19.R;

public class DrawinActivity extends AppCompatActivity {

    public static Intent newIntent(Context c) {
        Intent intent = new Intent(c, DrawinActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawin);

        FragmentManager manager = getSupportFragmentManager();
        if(manager.findFragmentById(R.id.frame_layout_drawin) == null) {
            manager.beginTransaction()
                    .add(R.id.frame_layout_drawin, DrawinFragment.newInstance())
                    .commit();
        }
    }
}
