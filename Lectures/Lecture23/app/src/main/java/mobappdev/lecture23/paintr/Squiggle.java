package mobappdev.lecture23.paintr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bobby on 12/2/2015.
 */
public class Squiggle extends Shape {
    private List<PointF> mPoints;

    public Squiggle(PointF start) {
        super(start);
        mPoints = new ArrayList<>();
        mPoints.add(start);
    }

    @Override
    public void setFinish(PointF finish) {
        mPoints.add(finish);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        PointF last = mPoints.get(0);
        for(int i = 1; i< mPoints.size(); i++) {
            PointF current = mPoints.get(i);
            canvas.drawLine(last.x, last.y, current.x, current.y, paint);
            last = current;
        }
    }
}
