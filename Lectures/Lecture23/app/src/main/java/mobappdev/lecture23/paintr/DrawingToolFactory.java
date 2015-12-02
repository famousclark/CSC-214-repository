package mobappdev.lecture23.paintr;

import android.graphics.PointF;
import android.support.annotation.NonNull;

/**
 * Created by Bobby on 12/2/2015.
 *
 * Knows how to create shapes of specific types.
 */
public class DrawingToolFactory {
    public enum DrawingToolType {
        LINE,
        SQUIGGLE,
        CIRCLE,
        PAINT_BRUSH,
        RECTANGLE,
        FILL
    }

    public static DrawingTool makeShape(@NonNull DrawingToolType type, PointF start, int color) {
        DrawingTool drawingTool;
        switch(type) {
            case LINE:
                drawingTool = new Line(start, color);
                break;
            case SQUIGGLE:
                drawingTool = new Squiggle(start, color);
                break;
            case CIRCLE:
                drawingTool = new Circle(start, color);
                break;
            case PAINT_BRUSH:
                drawingTool = new PaintBrush(start, color);
                break;
            case RECTANGLE:
                drawingTool = new Rectangle(start, color);
                break;
            case FILL:
                drawingTool = new Fill(color);
                break;
            default:
                drawingTool = null; // unknown drawingTool
                break;
        }
        return drawingTool;
    }
}
