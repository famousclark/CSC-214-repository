package csc296.demo.lecture04;

import android.widget.Button;

/**
 * Created by usx13992 on 8/27/2015.
 */
public class OuterClass {
    public int x;

    @Override
    public String toString() {
        return "I'm an outie!";
    }

    public class InnerClass {
        public int y;

        @Override
        public String toString() {
            return "I'm an innie!";
        }

        public void doSomething() {
            // this works because an inner class can see the enclosing class's fields
            int z = x + 4;

            // this will call the inner class's own toString method
            String s1 = this.toString();

            // to refer to the enclosing class's version of the method, the class name prefix
            // is required
            String s2 = OuterClass.this.toString();
        }

        public void doSomething(Button button) {
            button.setText(R.string.dynamic_string);
        }
    }

    public static class StaticClass {
        public int z;

        @Override
        public String toString() {
            return "I'm static D:";
        }
    }
}
