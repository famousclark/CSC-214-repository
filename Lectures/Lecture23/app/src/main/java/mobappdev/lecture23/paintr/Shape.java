package mobappdev.lecture23.paintr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

/**
 * Created by Bobby on 12/2/2015.
 */
public interface Shape {
    public void setFinish(PointF finish);

    public void draw(Canvas canvas, Paint paint);
}
