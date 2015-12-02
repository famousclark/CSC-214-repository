package mobappdev.lecture23.paintr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

/**
 * Created by usx13992 on 12/2/2015.
 */
public class Fill extends DrawingTool {
    public Fill(int color) {
        super(new PointF(0,0), color);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        int currentColor = paint.getColor();
        paint.setColor(getColor());
        canvas.drawRect(0f, 0f, canvas.getWidth(), canvas.getHeight(), paint);
        paint.setColor(currentColor);
    }
}
