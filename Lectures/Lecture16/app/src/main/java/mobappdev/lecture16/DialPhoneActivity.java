package mobappdev.lecture16;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DialPhoneActivity extends AppCompatActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, DialPhoneActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial_phone);
    }

    public void dialThePhone(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);

        startActivity(intent);
    }
}
