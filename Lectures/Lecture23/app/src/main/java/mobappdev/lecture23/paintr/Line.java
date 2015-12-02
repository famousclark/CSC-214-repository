package mobappdev.lecture23.paintr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

/**
 * Created by Bobby on 12/1/2015.
 */
public class Line implements Shape {
    private final PointF mStart;
    private PointF mFinish;

    public Line(PointF start) {
        mStart = start;
    }

    public PointF getStart() {
        return mStart;
    }

    public PointF getFinish() {
        return mFinish;
    }

    public void setFinish(PointF finish) {
        mFinish = finish;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawLine(mStart.x, mStart.y, mFinish.x, mFinish.y, paint);
    }
}
