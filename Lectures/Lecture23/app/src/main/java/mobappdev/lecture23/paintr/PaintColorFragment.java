package mobappdev.lecture23.paintr;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mobappdev.lecture23.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaintColorFragment extends Fragment {

    public interface OnPaintColorSelectedListener {
        public void onPaintColorSelected(int color);
        public void onPaintColorLongPress(int color);
    }

    private OnPaintColorSelectedListener mListener;

    public PaintColorFragment() {
        // Required empty public constructor
    }

    public static PaintColorFragment newInstance() {
        return new PaintColorFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnPaintColorSelectedListener)context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (OnPaintColorSelectedListener)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paint_color, container, false);

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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void addPaintSwatchListener(View swatch, final int colorId ) {
        swatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onPaintColorSelected(getResources().getColor(colorId));
            }
        });

        swatch.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mListener.onPaintColorLongPress(getResources().getColor(colorId));
                return true;
            }
        });
    }

}
