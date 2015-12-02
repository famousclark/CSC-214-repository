package mobappdev.lecture23.paintr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

/**
 * Created by Bobby on 12/1/2015.
 */
public class Line extends Shape {
    private PointF mFinish;

    public Line(PointF start) {
        super(start);
    }

    public PointF getFinish() {
        return mFinish;
    }

    public void setFinish(PointF finish) {
        mFinish = finish;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawLine(getStart().x, getStart().y, mFinish.x, mFinish.y, paint);
    }
}
