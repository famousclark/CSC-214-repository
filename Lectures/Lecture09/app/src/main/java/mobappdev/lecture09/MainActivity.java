package mobappdev.lecture09;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    public static final String KEY_MESSAGE = "MESSAGE";

    private TextView mTextViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewMessage = (TextView)findViewById(R.id.text_view_message);

        Button buttonChangeMessage = (Button)findViewById(R.id.button_change_message);
        buttonChangeMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChangeMessageActivity.class);
                intent.putExtra(KEY_MESSAGE, mTextViewMessage.getText().toString());
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            String message = data.getStringExtra(KEY_MESSAGE);
            mTextViewMessage.setText(message);
        }
    }
}
