package mobappdev.lecture23.paintr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

/**
 * Created by Bobby on 12/2/2015.
 */
public abstract class Shape {
    private final PointF mStart;

    public Shape(PointF start) {
        mStart = start;
    }

    public PointF getStart() {
        return mStart;
    }

    public abstract void setFinish(PointF finish);

    public abstract void draw(Canvas canvas, Paint paint);
}
