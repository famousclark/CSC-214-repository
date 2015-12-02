package mobappdev.lecture23.talktomyself;

import android.content.Context;
import android.content.Intent;

import mobappdev.lecture23.Fragtivity;

/**
 * Created by Bobby on 12/1/2015.
 */
public class TalkToMyselfActivity extends Fragtivity<TalkToMyselfFragment> {
    @Override
    public TalkToMyselfFragment createFragment() {
        return TalkToMyselfFragment.newInstance();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, TalkToMyselfActivity.class);
    }
}
