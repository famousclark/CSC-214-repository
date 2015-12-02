package mobappdev.lecture23;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Bobby on 12/1/2015.
 */
public abstract class Fragtivity<F extends Fragment> extends AppCompatActivity {
    public abstract F createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragtivity);

        FragmentManager manager = getSupportFragmentManager();
        if(manager.findFragmentById(R.id.frame_layout_container) == null) {
            manager.beginTransaction()
                    .add(R.id.frame_layout_container, createFragment())
                    .commit();
        }
    }
}
