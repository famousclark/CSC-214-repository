package mobappdev.lecture23.paintr;


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
public class PaintrFragment extends Fragment {

    private static final String TAG = "PaintrFragmentLog";
    private Surface mSurface;

    public PaintrFragment() {
        // Required empty public constructor
    }

    public static PaintrFragment newInstance() {
        return new PaintrFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_paintr, container, false);

        mSurface = (Surface)view.findViewById(R.id.surface);
        mSurface.setPaintColor(getResources().getColor(R.color.red));
        mSurface.setSurfaceColor(getResources().getColor(R.color.cream));
        mSurface.setCurrentDrawingTool(DrawingToolFactory.DrawingToolType.PAINT_BRUSH);

        //drawing tools
        addDrawingToolListener(view.findViewById(R.id.iv_line), DrawingToolFactory.DrawingToolType.LINE);
        addDrawingToolListener(view.findViewById(R.id.iv_squiggle), DrawingToolFactory.DrawingToolType.SQUIGGLE);
        addDrawingToolListener(view.findViewById(R.id.iv_stroke), DrawingToolFactory.DrawingToolType.PAINT_BRUSH);
        addDrawingToolListener(view.findViewById(R.id.iv_circle), DrawingToolFactory.DrawingToolType.CIRCLE);
        addDrawingToolListener(view.findViewById(R.id.iv_rectangle), DrawingToolFactory.DrawingToolType.RECTANGLE);

        View fill = view.findViewById(R.id.iv_fill);
        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSurface.fill();
            }
        });

        View erase = view.findViewById(R.id.iv_erase_all);
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSurface.erase();
            }
        });

        View undo = view.findViewById(R.id.iv_undo);
        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSurface.undo();
            }
        });


        // paint swatches
        addPaintSwatchListener(view.findViewById(R.id.swatch_red), R.color.red);
        addPaintSwatchListener(view.findViewById(R.id.swatch_orange), R.color.orange);
        addPaintSwatchListener(view.findViewById(R.id.swatch_yellow), R.color.yellow);
        addPaintSwatchListener(view.findViewById(R.id.swatch_green), R.color.green);
        addPaintSwatchListener(view.findViewById(R.id.swatch_blue), R.color.blue);
        addPaintSwatchListener(view.findViewById(R.id.swatch_purple), R.color.purple);
        addPaintSwatchListener(view.findViewById(R.id.swatch_brown), R.color.brown);
        addPaintSwatchListener(view.findViewById(R.id.swatch_black), R.color.black);
        addPaintSwatchListener(view.findViewById(R.id.swatch_white), R.color.white);

        return view;
    }

    private void addDrawingToolListener(View toolView,
                                        final DrawingToolFactory.DrawingToolType tool) {
        toolView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Setting drawing tool to: " + tool);
                mSurface.setCurrentDrawingTool(tool);
            }
        });
    }

    private void addPaintSwatchListener(View swatch, final int colorId ) {
        swatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSurface.setPaintColor(getResources().getColor(colorId));
            }
        });
    }

}
