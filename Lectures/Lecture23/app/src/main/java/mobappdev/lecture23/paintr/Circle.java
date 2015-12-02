package mobappdev.lecture23.paintr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

/**
 * Created by usx13992 on 12/2/2015.
 */
public class Circle extends DrawingTool {
    public Circle(PointF start, int color) {
        super(start, color);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        PointF start = getStart();
        PointF finish = getFinish();

        float centerX = (start.x + finish.x) / 2.0f;
        float centerY = (start.y + finish.y) / 2.0f;

        float radius = (float)Math.sqrt(
                Math.pow(start.x-centerX, 2) +
                Math.pow(start.y-centerY, 2)
        );

        paint.setColor(getColor());
        paint.setStrokeWidth(5.0f);
        canvas.drawCircle(centerX, centerY, radius, paint);
    }
}
