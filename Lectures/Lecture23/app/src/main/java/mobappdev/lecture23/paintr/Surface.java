package mobappdev.lecture23.paintr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mobappdev.lecture23.R;

/**
 * Created by Bobby on 12/1/2015.
 */
public class Surface extends View {
    private int mSelectedShape = ShapeFactory.LINE;
    private Shape mCurrentShape;
    private List<Shape> mShapes;

    private Paint mPaint;
    private Paint mCanvas;

    public Surface(Context context) {
        super(context);
    }

    public Surface(Context context, AttributeSet attrs) {
        super(context, attrs);

        mShapes = new ArrayList<>();

        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(R.color.red));

        mCanvas = new Paint();
        mCanvas.setColor(getResources().getColor(R.color.cream));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF current = new PointF(event.getX(), event.getY());
        String action = "";
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                mCurrentShape = ShapeFactory.makeShape(current, mSelectedShape);
                mShapes.add(mCurrentShape);
                break;
            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";
                if(mCurrentShape != null) {
                    mCurrentShape.setFinish(current);
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                mCurrentShape = null;
                break;
            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                mCurrentShape = null;
                break;
        }

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPaint(mCanvas);
        for(Shape shape : mShapes) {
            shape.draw(canvas, mPaint);
        }
    }
}
