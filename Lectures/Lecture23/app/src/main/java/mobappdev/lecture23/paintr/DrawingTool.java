package mobappdev.lecture23.paintr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

/**
 * Created by Bobby on 12/2/2015.
 *
 * The parent of things that can be drawn on the screen.
 */
public abstract class DrawingTool {
    private final PointF mStart;
    private final int mColor;
    private PointF mFinish;

    public DrawingTool(PointF start, int color) {
        mStart = start;
        mColor = color;
    }

    public PointF getStart() {
        return mStart;
    }

    public int getColor() {
        return mColor;
    }

    public void setFinish(PointF finish) {
        mFinish = finish;
    }

    public PointF getFinish() {
        return mFinish;
    }

    public abstract void draw(Canvas canvas, Paint paint);
}
