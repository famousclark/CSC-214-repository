package mobappdev.lecture19_5;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomewardBoundFragment extends Fragment {

    private static final String TAG = "HomewardBoundFragLog";

    private RecyclerView mRecyclerView;

    public HomewardBoundFragment() {
        // Required empty public constructor
    }

    public static HomewardBoundFragment newInstance() {
        return new HomewardBoundFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homeward_bound, container, false);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recylcer_view_homeward);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        Intent startupIntent = new Intent(Intent.ACTION_MAIN);
        startupIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        PackageManager pm = getActivity().getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(startupIntent, 0);
        Collections.sort(activities, new Comparator<ResolveInfo>() {
            public int compare(ResolveInfo a, ResolveInfo b) {
                PackageManager pm = getActivity().getPackageManager();
                return String.CASE_INSENSITIVE_ORDER.compare(
                        a.loadLabel(pm).toString(),
                        b.loadLabel(pm).toString()
                );
            }
        });

        mRecyclerView.setAdapter(new ActivityAdapter(activities));

        Log.i(TAG, "Found " + activities.size() + " activities.");

        return view;
    }

    private class ActivityHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ResolveInfo mResolveInfo;
        private ImageView mImageViewIcon;
        private TextView mTextViewName;


        public ActivityHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mImageViewIcon = (ImageView)itemView.findViewById(R.id.image_view_icon);
            mTextViewName = (TextView)itemView.findViewById(R.id.text_view_label);
        }

        public void bindActivity(ResolveInfo resolveInfo) {
            mResolveInfo = resolveInfo;
            PackageManager pm = getActivity().getPackageManager();
            Drawable icon = mResolveInfo.loadIcon(pm);
            mImageViewIcon.setImageDrawable(icon);
            String appName = mResolveInfo.loadLabel(pm).toString();
            mTextViewName.setText(appName);
        }

        @Override
        public void onClick(View v) {
            ActivityInfo activityInfo = mResolveInfo.activityInfo;
            Intent i = new Intent(Intent.ACTION_MAIN)
                    .setClassName(activityInfo.applicationInfo.packageName, activityInfo.name)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
    }

    private class ActivityAdapter extends RecyclerView.Adapter<ActivityHolder> {
        private final List<ResolveInfo> mActivities;

        public ActivityAdapter(List<ResolveInfo> activities) {
            mActivities = activities;
        }

        @Override
        public ActivityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item_application_view, parent, false);
            return new ActivityHolder(view);
        }

        @Override
        public void onBindViewHolder(ActivityHolder holder, int position) {
            holder.bindActivity(mActivities.get(position));
        }

        @Override
        public int getItemCount() {
            return mActivities.size();
        }
    }

}
