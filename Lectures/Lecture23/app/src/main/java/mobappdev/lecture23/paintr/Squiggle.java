package mobappdev.lecture23.paintr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bobby on 12/2/2015.
 */
public class Squiggle extends DrawingTool {
    public static final float DEFAULT_STROKE_WIDTH = 5.0f;
    private List<PointF> mPoints;
    private final float mStrokeWidth;

    public Squiggle(PointF start, int color) {
        this(start, color, DEFAULT_STROKE_WIDTH);
    }

    public Squiggle(PointF start, int color, float strokeWidth) {
        super(start, color);
        mStrokeWidth = strokeWidth;
        mPoints = new ArrayList<>();
        mPoints.add(start);
    }

    @Override
    public void setFinish(PointF finish) {
        super.setFinish(finish);
        mPoints.add(finish);
    }

    public List<PointF> getPoints() {
        return mPoints;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        PointF last = mPoints.get(0);
        paint.setColor(getColor());
        paint.setStrokeWidth(mStrokeWidth);

        for(int i = 1; i< mPoints.size(); i++) {
            PointF current = mPoints.get(i);
            canvas.drawLine(last.x, last.y, current.x, current.y, paint);
            last = current;
        }
    }
}
