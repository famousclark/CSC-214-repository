package mobappdev.lecture23.paintr;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import mobappdev.lecture23.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BrushFragment extends Fragment {


    private static final String ARG_INITIAL_BRUSH_SIZE = "mobappdev.paintr.initial_brush_size";
    private static final String ARG_PAINT_COLOR = "mobappdev.paintr.color";

    public interface OnBrushSizeSelectedListener {
        public void OnBrushSizeSelected(float brushSize);
    }

    private OnBrushSizeSelectedListener mListener;
    private SeekBar mSeekBar;
    private BrushView mBrushView;

    public BrushFragment() {
        // Required empty public constructor
    }

    public static BrushFragment newInstance(float initialSize, int color) {
        Bundle args = new Bundle();
        args.putFloat(ARG_INITIAL_BRUSH_SIZE, initialSize);
        args.putInt(ARG_PAINT_COLOR, color);

        BrushFragment fragment = new BrushFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_brush, container, false);

        Bundle args = getArguments();
        float initialBrushSize = args.getFloat(ARG_INITIAL_BRUSH_SIZE);
        int paintColor = args.getInt(ARG_PAINT_COLOR);

        mBrushView = (BrushView)view.findViewById(R.id.brush_view);
        mBrushView.setSizeInPixels(initialBrushSize);
        mBrushView.setPaintColor(paintColor);

        mSeekBar = (SeekBar)view.findViewById(R.id.seekbar_brush_size);
        mSeekBar.setMax((int)Surface.MAXIMUM_BRUSH_SIZE);
        mSeekBar.setProgress((int)initialBrushSize);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mBrushView.setSizeInPixels(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // nada
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mListener.OnBrushSizeSelected(mBrushView.getSizeInPixels());
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnBrushSizeSelectedListener)context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (OnBrushSizeSelectedListener)activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
