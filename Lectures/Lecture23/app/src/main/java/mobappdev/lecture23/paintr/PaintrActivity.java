package mobappdev.lecture23.paintr;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import mobappdev.lecture23.R;

public class PaintrActivity extends AppCompatActivity implements
        DrawingToolFragment.OnDrawingToolInteractionListener,
        BrushFragment.OnBrushSizeSelectedListener,
        PaintColorFragment.OnPaintColorSelectedListener {

    private static final String TAG = "PaintrActivityLog";

    private FrameLayout mToolFragmentContainer;
    private DrawingToolFragment mDrawingToolFragment;
    private BrushFragment mBrushFragment;
    private PaintrFragment mPaintrFragment;
    private PaintColorFragment mPaintColorFragment;

    public static Intent newIntent(Context context) {
        return new Intent(context, PaintrActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paintr);

        mToolFragmentContainer = (FrameLayout)findViewById(R.id.fl_tool_fragment);

        FragmentManager manager = getSupportFragmentManager();

        mBrushFragment = BrushFragment.newInstance(5.0f, getColor(R.color.red));

        mDrawingToolFragment = (DrawingToolFragment)manager.findFragmentById(R.id.fl_drawing_tools);
        if(mDrawingToolFragment == null) {
            mDrawingToolFragment = DrawingToolFragment.newInstance();
            manager.beginTransaction()
                    .add(R.id.fl_drawing_tools, mDrawingToolFragment)
                    .commit();
        }

        mPaintrFragment = (PaintrFragment)manager.findFragmentById(R.id.fl_paintr);
        if(mPaintrFragment == null) {
            mPaintrFragment = PaintrFragment.newInstance();
            manager.beginTransaction()
                    .add(R.id.fl_paintr, mPaintrFragment)
                    .commit();
        }

        mPaintColorFragment = (PaintColorFragment)manager.findFragmentById(R.id.fl_paint_color);
        if(mPaintColorFragment == null) {
            mPaintColorFragment = PaintColorFragment.newInstance();
            manager.beginTransaction()
                    .add(R.id.fl_paint_color, PaintColorFragment.newInstance())
                    .commit();
        }
    }

    @Override
    public void onDrawingToolSelected(DrawingToolFactory.DrawingToolType tool) {
        Log.i(TAG, "Drawing tool selected: " + tool);
    }

    @Override
    public void onDrawingToolLongPress(DrawingToolFactory.DrawingToolType tool) {
        Log.i(TAG, "Drawing tool long pressed: " + tool);
        switch(tool) {
            case PAINT_BRUSH:
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.fl_tool_fragment, mBrushFragment)
                        .commit();
                mToolFragmentContainer.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    @Override
    public void onFill() {
        Log.i(TAG, "Fill!");
    }

    @Override
    public void onErase() {
        Log.i(TAG, "Erase!");
    }

    @Override
    public void onUndo() {
        Log.i(TAG, "Undo!");
    }

    @Override
    public void OnBrushSizeSelected(float brushSize) {
        Log.i(TAG, "Brush Size selected: " + brushSize);
        mToolFragmentContainer.setVisibility(View.GONE);
    }

    @Override
    public void onPaintColorSelected(int color) {
        Log.i(TAG, "Paint color selected: " + color);
    }
}
