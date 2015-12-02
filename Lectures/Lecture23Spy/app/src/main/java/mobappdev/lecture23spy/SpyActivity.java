package mobappdev.lecture23spy;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SpyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spy);

        FragmentManager manager = getSupportFragmentManager();
        if(manager.findFragmentById(R.id.fl_container) == null) {
            manager.beginTransaction()
                    .add(R.id.fl_container, SpyFragment.newInstance())
                    .commit();
        }
    }
}
