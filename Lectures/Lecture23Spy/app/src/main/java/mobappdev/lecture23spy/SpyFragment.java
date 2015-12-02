package mobappdev.lecture23spy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpyFragment extends Fragment {


    public SpyFragment() {
        // Required empty public constructor
    }

    public static SpyFragment newInstance() {
        return new SpyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_spy, container, false);

        RecyclerView rvEavesdroppings = (RecyclerView)view.findViewById(R.id.rv_overheard);
        rvEavesdroppings.setLayoutManager(new LinearLayoutManager(getContext()));
        Set<String> eavesdroppings = Prefs.getEavesdroppings(getActivity());
        rvEavesdroppings.setAdapter(new EavesdroppingAdapter(eavesdroppings));

        return view;
    }

    private class EavesdroppingHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public EavesdroppingHolder(View itemView) {
            super(itemView);
            mTextView = (TextView)itemView;
        }

        public void bindEavesdropping(String eavesdropped, int bgColor, int textColor) {
            mTextView.setText(eavesdropped);
            mTextView.setBackgroundColor(bgColor);
            mTextView.setTextColor(textColor);
        }

        public void setColors(int bgColor, int textColor) {

        }
    }

    private class EavesdroppingAdapter extends RecyclerView.Adapter<EavesdroppingHolder> {

        private List<String> mEavesdroppings;

        public EavesdroppingAdapter(Set<String> eavesdroppings) {
            mEavesdroppings = new ArrayList<>();
            mEavesdroppings.addAll(eavesdroppings);
        }

        @Override
        public EavesdroppingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.view_eavesdropping, parent, false);
            return new EavesdroppingHolder(view);
        }

        @Override
        public void onBindViewHolder(EavesdroppingHolder holder, int position) {
            int bgColor;
            int textColor;
            if(position % 2 == 0) {
                bgColor = getResources().getColor(R.color.slateGray);
                textColor = getResources().getColor(R.color.chalkWhite);
            }
            else {
                bgColor = getResources().getColor(R.color.chalkWhite);
                textColor = getResources().getColor(R.color.slateGray);
            }
            holder.bindEavesdropping(mEavesdroppings.get(position), bgColor, textColor);
        }

        @Override
        public int getItemCount() {
            return mEavesdroppings.size();
        }
    }

}
