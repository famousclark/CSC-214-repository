package mobappdev.lecture16;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ContactsActivity extends AppCompatActivity {

    private TextView mContactName;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ContactsActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        mContactName = (TextView)findViewById(R.id.text_view_contact_name);
    }

    public void pickAContact(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setData(Contacts.CONTENT_URI);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data != null) {
            Uri contactUri = data.getData();
            String queryFields[] = new String[] {
                    Contacts.DISPLAY_NAME,
            };
            Cursor cursor = getContentResolver().query(contactUri, queryFields, null, null, null);
            try {
                if(cursor.getCount() != 0) {
                    cursor.moveToFirst();
                    String contactName = cursor.getString(
                            cursor.getColumnIndex(Contacts.DISPLAY_NAME));
                    mContactName.setText(contactName);
                }
            }
            finally {
                cursor.close();
            }
        }
    }
}
