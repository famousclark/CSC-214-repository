package mobappdev.lecture23.paintr;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobappdev.lecture23.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrawingToolFragment extends Fragment {
    private static final String TAG = "DrawingToolFragmentLog";

    public interface OnDrawingToolInteractionListener {
        // called when the user taps a drawing tool in the bar
        public void onDrawingToolSelected(DrawingToolFactory.DrawingToolType tool);
        // called when the user long presses a drawing tool
        public void onDrawingToolLongPress(DrawingToolFactory.DrawingToolType tool);
        // called when the fill tool is used
        public void onFill();
        // called when the erase tool is used
        public void onErase();
        // called when the undo tool is used
        public void onUndo();
    }

    private OnDrawingToolInteractionListener mListener;

    public DrawingToolFragment() {
        // Required empty public constructor
    }

    public static DrawingToolFragment newInstance() {
        return new DrawingToolFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnDrawingToolInteractionListener)context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (OnDrawingToolInteractionListener)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drawing_tool, container, false);

        //drawing tools
        addDrawingToolListener(view.findViewById(R.id.iv_line), DrawingToolFactory.DrawingToolType.LINE);
        addDrawingToolListener(view.findViewById(R.id.iv_paint_brush), DrawingToolFactory.DrawingToolType.PAINT_BRUSH);
        addDrawingToolListener(view.findViewById(R.id.iv_circle), DrawingToolFactory.DrawingToolType.CIRCLE);
        addDrawingToolListener(view.findViewById(R.id.iv_rectangle), DrawingToolFactory.DrawingToolType.RECTANGLE);

        View fill = view.findViewById(R.id.iv_fill);
        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFill();
            }
        });

        View erase = view.findViewById(R.id.iv_erase_all);
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onErase();
            }
        });

        View undo = view.findViewById(R.id.iv_undo);
        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onUndo();
            }
        });

        return view;
    }

    private void addDrawingToolListener(View toolView,
                                        final DrawingToolFactory.DrawingToolType tool) {
        toolView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Drawing Tool selected: " + tool);
                mListener.onDrawingToolSelected(tool);
            }
        });

        toolView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.i(TAG, "Drawing Tool Long Pressed: " + tool);
                mListener.onDrawingToolLongPress(tool);
                return true;
            }
        });
    }

}
