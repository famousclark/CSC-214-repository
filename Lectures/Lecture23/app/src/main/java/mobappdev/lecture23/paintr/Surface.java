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

/**
 * Created by Bobby on 12/1/2015.
 *
 * A simple paint program.
 */
public class Surface extends View {
    private static final String TAG = "SurfaceLog";

    private DrawingToolFactory.DrawingToolType mCurrentType;
    private DrawingTool mCurrentDrawingTool;
    private List<DrawingTool> mDrawingTools;

    private Paint mPaint;
    private Paint mCanvas;

    public Surface(Context context) {
        super(context);
    }

    public Surface(Context context, AttributeSet attrs) {
        super(context, attrs);

        mDrawingTools = new ArrayList<>();

        mPaint = new Paint();

        mCanvas = new Paint();

        Log.i(TAG, attrs.getAttributeValue(null, "canvasColor"));
        Log.i(TAG, attrs.getAttributeValue(null, "paintColor"));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF current = new PointF(event.getX(), event.getY());
        String action = "";
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                mCurrentDrawingTool = DrawingToolFactory.makeShape(mCurrentType, current,
                        mPaint.getColor());
                mDrawingTools.add(mCurrentDrawingTool);
                break;
            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";
                if(mCurrentDrawingTool != null) {
                    mCurrentDrawingTool.setFinish(current);
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                mCurrentDrawingTool = null;
                invalidate();
                break;
            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                mCurrentDrawingTool = null;
                break;
        }

        Log.i(TAG, action + " at " + current.x + ", " + current.y);

        return true;
    }

    public void fill() {
        Log.i(TAG, "should fill");
        mDrawingTools.add(DrawingToolFactory.makeShape(DrawingToolFactory.DrawingToolType.FILL,
                null, mPaint.getColor()));
        invalidate();
    }

    public void erase() {
        Log.i(TAG, "should erase");
        mDrawingTools.add(DrawingToolFactory.makeShape(DrawingToolFactory.DrawingToolType.FILL,
                null, mCanvas.getColor()));
        invalidate();
    }

    public boolean undo() {
        boolean undid = false;
        int size = mDrawingTools.size();
        if(size > 0) {
            mDrawingTools.remove(size-1);
            invalidate();
            undid = true;
        }
        return undid;
    }

    public void setPaintColor(int color) {
        mPaint.setColor(color);
    }

    public int getPaintColor() {
        return mPaint.getColor();
    }

    public void setSurfaceColor(int color) {
        mCanvas.setColor(color);
    }

    public void setCurrentDrawingTool(DrawingToolFactory.DrawingToolType drawingTool) {
        mCurrentType = drawingTool;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPaint(mCanvas);
        for(DrawingTool drawingTool : mDrawingTools) {
            drawingTool.draw(canvas, mPaint);
        }
    }
}
