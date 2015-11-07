package mobappdev.lecture17.reclcyclerview;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mobappdev.lecture17.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    public interface ItemClickListener {
        public void onItemClicked(CharSequence message);
    }

    private ItemClickListener mListener;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (ItemClickListener)context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (ItemClickListener)activity;
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
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view_example);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MyAdapter(100));

        return view;
    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private int mSize;

        public MyAdapter(int size) {
            mSize = size;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.recycler_view_layout, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.bind(position);
        }

        @Override
        public int getItemCount() {
            return mSize;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        private int mNumberOfTimesBound;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView)itemView;
            mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(mTextView.getText());
                }
            });
            mNumberOfTimesBound =0;
        }

        public void bind(int position) {
            mNumberOfTimesBound = mNumberOfTimesBound + 1;
            String message = "Item #" + position + " (bound " + mNumberOfTimesBound + " times)";
            mTextView.setText(message);
        }
    }


}
