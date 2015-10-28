package mobappdev.lecture16;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DialPhoneActivity extends AppCompatActivity {

    private static final int REQUEST_CALL_PERMISSIONS = 1;

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
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED) {
            reallyDialThePhone();
        }
        else {
            requestPermissions(new String[]{ Manifest.permission.CALL_PHONE},
                    REQUEST_CALL_PERMISSIONS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if(requestCode == REQUEST_CALL_PERMISSIONS) {
            if(grantResults.length == 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                reallyDialThePhone();
            }
            else {
                Toast.makeText(this, R.string.message_call_permission_denied,
                        Toast.LENGTH_SHORT).show();
            }
        }
        else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void reallyDialThePhone() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        Uri number = Uri.parse("tel:" + mNumber.getText().toString());
        intent.setData(number);
        startActivity(intent);
    }
}
