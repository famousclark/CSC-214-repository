package csc296.demo.lecture04;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RabbitHoleActivity extends Activity {

    private Button mButtonEatMe;
    private Button mButtonDrinkMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture04);

        mButtonEatMe = (Button)findViewById(R.id.button_eat_me);
        mButtonEatMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RabbitHoleActivity.this, R.string.message_bigger,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mButtonDrinkMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RabbitHoleActivity.this, R.string.message_smaller,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
