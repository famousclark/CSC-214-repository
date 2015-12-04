package mobappdev.lecture23.paintr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by usx13992 on 12/4/2015.
 *
 * Class that provides a view of the size and shape of the current brush.
 */
public class BrushView extends View {
    private float mSizeInPixels;
    private int mColor = Color.BLACK;
    private Paint mPaint = new Paint();

    public BrushView(Context context) {
        super(context);
    }

    public BrushView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setPaintColor(int color) {
        mColor = color;
        invalidate();
    }

    public void setSizeInPixels(float sizeInPixels) {
        mSizeInPixels = sizeInPixels;
        invalidate();
    }

    public float getSizeInPixels() {
        return mSizeInPixels;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        float cx = width / 2;
        float cy = height / 2;
        float radius = mSizeInPixels / 2;

        mPaint.setColor(mColor);
        canvas.drawCircle(width/2, height/2, mSizeInPixels/2, mPaint);
    }
}
