package mobappdev.lecture23.paintr;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mobappdev.lecture23.Fragtivity;

public class PaintrActivity extends Fragtivity<PaintrFragment> {

    public static Intent newIntent(Context context) {
        return new Intent(context, PaintrActivity.class);
    }

    @Override
    public PaintrFragment createFragment() {
        return PaintrFragment.newInstance();
    }

}
