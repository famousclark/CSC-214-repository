package mobappdev.lecture23.paintr;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

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

        return view;
    }
}
