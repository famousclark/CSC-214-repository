package mobappdev.lecture09;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ChangeMessageActivity extends Activity
        implements ChangeMessageFragment.MessageChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_message);

        ChangeMessageFragment fragment = new ChangeMessageFragment();
        fragment.setArguments(getIntent().getExtras());
        getFragmentManager()
                .beginTransaction()
                .add(R.id.frame_layout_change_message, fragment)
                .commit();
    }

    @Override
    public void messageChanged(CharSequence message) {
        Intent data = new Intent();
        data.putExtra(MainActivity.KEY_MESSAGE, message);
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public void messageCanceled() {
        setResult(RESULT_CANCELED);
        finish();
    }
}
