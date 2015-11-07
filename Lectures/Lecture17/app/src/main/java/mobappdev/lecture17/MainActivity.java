package mobappdev.lecture17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mobappdev.lecture17.masterdetail.MasterDetailActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleMasterDetail(View view) {
        startActivity(new Intent(this, MasterDetailActivity.class));
    }
}
