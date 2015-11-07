package mobappdev.lecture17.masterdetail;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mobappdev.lecture17.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment {

    public interface DetailItemClickListener {
        public void OnDetailItemClick(CharSequence text, int background);
    }

    private DetailItemClickListener mListener;

    public MasterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (DetailItemClickListener)context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (DetailItemClickListener)activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_master, container, false);

        final TextView top = (TextView)view.findViewById(R.id.text_view_top);
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OnDetailItemClick(top.getText(), Color.parseColor("#FF5555"));
            }
        });

        final TextView middle = (TextView)view.findViewById(R.id.text_view_middle);
        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OnDetailItemClick(middle.getText(), Color.parseColor("#FFFFAA"));
            }
        });

        final TextView bottom = (TextView)view.findViewById(R.id.text_view_bottom);
        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OnDetailItemClick(bottom.getText(), Color.parseColor("#5555FF"));
            }
        });

        return view;
    }
}
