package mobappdev.lecture23.paintr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

/**
 * Created by usx13992 on 12/2/2015.
 */
public class Rectangle extends DrawingTool {
    public Rectangle(PointF start, int color) {
        super(start, color);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        PointF start = getStart();
        PointF finish = getFinish();

        float left = Math.min(start.x, finish.x);
        float top = Math.min(start.y, finish.y);
        float right = Math.max(start.x, finish.x);
        float bottom = Math.max(start.y, finish.y);

        paint.setColor(getColor());
        canvas.drawRect(left, top, right, bottom, paint);
    }
}
