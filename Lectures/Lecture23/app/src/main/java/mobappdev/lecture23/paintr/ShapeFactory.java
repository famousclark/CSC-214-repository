package mobappdev.lecture23.paintr;

import android.graphics.PointF;

/**
 * Created by Bobby on 12/2/2015.
 */
public class ShapeFactory {
    public static final int LINE = 2;
    public static final int SQUIGGLE = 4;

    public static Shape makeShape(PointF start, int type) {
        Shape shape;
        switch(type) {
            case LINE:
                shape = new Line(start);
                break;
            case SQUIGGLE:
                shape = new Squiggle(start);
                break;
            default:
                shape = null; // unknown shape
                break;
        }
        return shape;
    }
}
