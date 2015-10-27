package mobappdev.lecture16;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUrl = (EditText)findViewById(R.id.edit_text_url);
    }

    public void browseToUrl(View view) {
        String uriString = mUrl.getText().toString();
        Uri location = Uri.parse(uriString);
        Intent intent = new Intent(Intent.ACTION_VIEW, location);
        intent.setType("text/html");
        startActivity(intent);
    }
}
