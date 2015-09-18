package mobappdev.lecture07;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class ChangeFontActivity extends Activity {

    CheckBox mBoldCheckBox;
    CheckBox mItalicCheckBox;
    CheckBox mUnderlinedCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_font);

        Intent intent = getIntent();

        mBoldCheckBox = (CheckBox)findViewById(R.id.check_box_bold);
        mBoldCheckBox.setChecked(intent.getBooleanExtra(HelloFont.KEY_BOLD, false));

        mItalicCheckBox = (CheckBox)findViewById(R.id.check_box_italic);
        mItalicCheckBox.setChecked(intent.getBooleanExtra(HelloFont.KEY_ITALIC, false));

        mUnderlinedCheckBox = (CheckBox)findViewById(R.id.check_box_underlined);
        mUnderlinedCheckBox.setChecked(intent.getBooleanExtra(HelloFont.KEY_UNDERLINED, false));

        Button okButton = (Button)findViewById(R.id.button_ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra(HelloFont.KEY_BOLD, mBoldCheckBox.isChecked());
                data.putExtra(HelloFont.KEY_ITALIC, mItalicCheckBox.isChecked());
                data.putExtra(HelloFont.KEY_UNDERLINED, mUnderlinedCheckBox.isChecked());
                setResult(RESULT_OK, data);
                finish();
            }
        });

        Button cancelButton = (Button)findViewById(R.id.button_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

}
