package csc296.demo.lecture04;

import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by usx13992 on 8/27/2015.
 */
public class SomeOtherClass {
    private static final String TAG = "SomeOtherClass";

    private OuterClass outer;
    private OuterClass.InnerClass inner;
    private OuterClass.StaticClass statick;

    public void doSomething() {
        outer = new OuterClass();

        // inner classes can't be instantiated without an instance of the
        // enclosing class
        inner = outer.new InnerClass(); // so weird
        inner = new OuterClass().new InnerClass(); // also works.  weeeeird.

        // static classes are more independent of the enclosing class, and so they can be
        // instantiated without an instance of the enclosing class
        statick = new OuterClass.StaticClass();
    }

    public void doSomething(Button button) {
        final int a = 5;
        int b = 6;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, this.toString());

                Log.d(TAG, SomeOtherClass.this.toString());

                Log.d(TAG, "" + a);

                // won't work, not final
                //Log.d(TAG, "" + b);
            }
        });
    }
}
