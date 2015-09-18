package mobappdev.lecture07;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelloFont extends Activity {
    static final String KEY_BOLD = "mobappdev.lecture07.BOLD";
    static final String KEY_ITALIC = "mobappdev.lecture07.ITALIC";
    static final String KEY_UNDERLINED = "mobappdev.lecture07.UNDERLINED";

    private static final int RC_FONT = 2;

    private TextView mHelloWorldTextView;
    private boolean mIsUnderlined = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_font);

        mHelloWorldTextView = (TextView)findViewById(R.id.text_view_hello_world);
        Button changeFont = (Button)findViewById(R.id.button_change_font);
        changeFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloFont.this, ChangeFontActivity.class);

                Typeface typeface = mHelloWorldTextView.getTypeface();
                intent.putExtra(KEY_BOLD, typeface.isBold());
                intent.putExtra(KEY_ITALIC, typeface.isItalic());
                intent.putExtra(KEY_UNDERLINED, mIsUnderlined);

                startActivityForResult(intent, RC_FONT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( resultCode != RESULT_CANCELED ) {
            boolean bold = data.getBooleanExtra(KEY_BOLD, false);
            boolean italic = data.getBooleanExtra(KEY_ITALIC, false);
            boolean underlined = data.getBooleanExtra(KEY_UNDERLINED, false);
            updateFont(bold, italic, underlined);
        }

    }

    private void updateFont(boolean bold, boolean italic, boolean underlined) {
        Typeface typeface = mHelloWorldTextView.getTypeface();
        int style = Typeface.NORMAL;

        if(bold && italic) {
            style = Typeface.BOLD_ITALIC;
        }
        else if(bold) {
            style = Typeface.BOLD;
        }
        else if(italic) {
            style = Typeface.ITALIC;
        }

        Typeface newTypeface = Typeface.create(typeface, style);
        mHelloWorldTextView.setTypeface(newTypeface);

        if(underlined) {
            CharSequence message = mHelloWorldTextView.getText();
            SpannableString content = new SpannableString(message);
            content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
            mHelloWorldTextView.setText(content);
            mIsUnderlined = true;
        }
        else {
            //the underline tends to be sticky, so reset the text entirely to wipe it out
            mHelloWorldTextView.setText(mHelloWorldTextView.getText().toString());
            mIsUnderlined = false;
        }

    }
}
