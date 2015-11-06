package mobappdev.lecture17.simplemaster;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mobappdev.lecture17.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleMasterFragment extends Fragment {
    private static final int PINK = Color.rgb(255, 64, 64);
    private static final int YELLOW = Color.rgb(255, 255, 50);

    public interface SimpleItemClickListener {
        public void simpleItemClicked(CharSequence item, int background);
    }

    private SimpleItemClickListener mListener;

    public SimpleMasterFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (SimpleItemClickListener)context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (SimpleItemClickListener)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_master, container, false);

        RecyclerView recycler = (RecyclerView)view.findViewById(R.id.recycler_view_simple);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new SimpleAdapter(1000));

        return view;
    }

    /**
     * Rrepresents a fake colleciton of items of a configurable size.
     */
    private class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
        private int mSize;

        SimpleAdapter(int size) {
            mSize = size;
        }

        @Override
        public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.view_simple, parent, false);
            return new SimpleViewHolder(view);
        }

        @Override
        public void onBindViewHolder(SimpleViewHolder holder, int position) {
            holder.bind(position);
        }

        @Override
        public int getItemCount() {
            return mSize;
        }
    }

    /**
     * This view holder updates the view that it holds to show the view's position in the
     * artificial collection and the number of times that the view holder has been bound
     * or rebound to an item in the fake collection.
     */
    private class SimpleViewHolder extends RecyclerView.ViewHolder {


        private TextView mTextView;
        private int mBindCount;
        private int mBackground;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView)itemView;
            mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.simpleItemClicked(mTextView.getText(),
                            mBackground);
                }
            });
            mBindCount = 0;
        }

        public void bind(int position) {
            if(position%2 == 0) {
                mBackground = PINK;
            }
            else {
                mBackground = YELLOW;
            }

            mBindCount = mBindCount + 1;
            String message = "Binding to " + position + "(bound " + mBindCount + " times)";
            mTextView.setText(message);
            mTextView.setBackgroundColor(mBackground);
        }
    }
}
