package mobappdev.lecture23.paintr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by usx13992 on 12/2/2015.
 *
 * A variation of the squiggle that draws a series of circles to create a fatter line.
 */
public class PaintBrush extends Squiggle {
    private List<PointF> mPoints;

    public PaintBrush(PointF start, int color, float brushSize) {
        super(start, color, brushSize);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        super.draw(canvas, paint);
        List<PointF> points = getPoints();
        for(PointF point : points) {
            canvas.drawCircle(point.x, point.y, getBrushSize()/2, paint);
        }
    }
}
