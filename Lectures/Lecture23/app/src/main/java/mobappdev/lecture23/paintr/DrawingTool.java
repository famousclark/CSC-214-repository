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
    private final float mBrushSize;
    private PointF mFinish;

    public DrawingTool(PointF start, int color, float brushSize) {
        mStart = start;
        mColor = color;
        mBrushSize = brushSize;
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

    public float getBrushSize() {
        return mBrushSize;
    }

    public abstract void draw(Canvas canvas, Paint paint);
}
