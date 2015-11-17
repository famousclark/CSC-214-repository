package mobappdev.lecture19.themes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture19.R;

public class TheminActivity extends AppCompatActivity {

    public static Intent newIntent(Context c) {
        Intent intent = new Intent(c, TheminActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themin);
    }
}
