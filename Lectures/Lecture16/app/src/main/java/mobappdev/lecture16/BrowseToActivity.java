package mobappdev.lecture16;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BrowseToActivity extends AppCompatActivity {

    private EditText mUrl;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, BrowseToActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_to);
        mUrl = (EditText)findViewById(R.id.edit_text_url);
    }

    public void browseToUrl(View view) {
        String uriString = mUrl.getText().toString();
        if(uriString.startsWith("http") == false) {
            uriString = "http://" + uriString;
        }
        Uri location = Uri.parse(uriString);
        Intent intent = new Intent(Intent.ACTION_VIEW, location);
        // docs say this should be supported, but causes app crash with "no
        // activity found to handle intent.  go figure.
        //intent.setType("text/html");
        startActivity(intent);

    }

    public void badIntent(View view) {
        Intent bad = new Intent();
        bad.setAction(Intent.ACTION_VIEW);
        bad.setType("text/html");

        PackageManager manager = getPackageManager();
        if(manager.resolveActivity(bad, PackageManager.MATCH_DEFAULT_ONLY) == null) {
            Toast.makeText(this, R.string.message_no_activities, Toast.LENGTH_SHORT).show();
        }
    }
}
