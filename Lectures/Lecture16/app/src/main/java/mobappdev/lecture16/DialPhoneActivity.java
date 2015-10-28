package mobappdev.lecture16;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DialPhoneActivity extends AppCompatActivity {

    private EditText mNumber;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, DialPhoneActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial_phone);

        mNumber = (EditText)findViewById(R.id.edit_text_number);
    }

    public void dialThePhone(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        Uri number = Uri.parse("tel:" + mNumber.getText().toString());
        intent.setData(number);
        startActivity(intent);
    }
}
