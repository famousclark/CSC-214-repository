package mobappdev.lecture23.paintr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

/**
 * Created by Bobby on 12/1/2015.
 */
public class Line extends DrawingTool {

    public Line(PointF start, int color) {
        super(start, color, 5.0f);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        PointF start = getStart();
        PointF finish = getFinish();
        paint.setColor(getColor());
        paint.setStrokeWidth(5.0f);
        canvas.drawLine(start.x, start.y, finish.x, finish.y, paint);
    }
}
