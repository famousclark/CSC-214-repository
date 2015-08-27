package csc296.demo.lecture04;

/**
 * Created by usx13992 on 8/27/2015.
 */
public class SomeOtherClass {
    private OuterClass outer;
    private OuterClass.InnerClass inner;
    private OuterClass.StaticClass statick;

    public void doSomething() {
        outer = new OuterClass();

        // this won't work; only static classes can be instantiated without an instance of the
        // enclosing class
        //inner = new OuterClass.InnerClass();

        // static classes are more independent of the enclosing class, and so they can be
        // instantiated without an instance of the enclosing class
        statick = new OuterClass.StaticClass();
    }
}
