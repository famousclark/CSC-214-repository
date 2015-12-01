package mobappdev.lecture22.receiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import mobappdev.lecture22.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReceiverFragment extends Fragment {

    private static final String TAG = "ReceiverFragmentLog";
    private TextView mBattery;
    private BatteryReceiver mBatteryReceiver;

    public ReceiverFragment() {
        // Required empty public constructor
    }

    public static ReceiverFragment newInstance() {
        return new ReceiverFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receiver, container, false);

        long timestamp = Prefs.getBootTime(getActivity());
        Date boot = new Date(timestamp);

        TextView bootDate = (TextView)view.findViewById(R.id.text_view_boot_date);
        bootDate.setText(DateFormat.getLongDateFormat(getActivity()).format(boot));

        TextView bootTime = (TextView)view.findViewById(R.id.text_view_boot_time);
        bootTime.setText(DateFormat.getTimeFormat(getActivity()).format(boot));

        mBattery = (TextView)view.findViewById(R.id.text_view_battery);

        mBatteryReceiver = new BatteryReceiver();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        getActivity().registerReceiver(mBatteryReceiver, filter);
        Log.i(TAG, "Receiver registered.");
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().unregisterReceiver(mBatteryReceiver);
        Log.i(TAG, "Receiver unregistered.");
    }

    private class BatteryReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, "Intent received: " + intent.getAction());

            double level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            double scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            double current = level / scale;

            Log.i(TAG, "level: " + level + ", scale: " + scale + ", current: " + current);

            int color;
            String suffix;

            if(current < 0 ) {
                suffix = getString(R.string.battery_unknown);
                color = Color.BLACK;
            }
            else
            if(current < 0.20){
                suffix = getString(R.string.battery_low);
                color = Color.RED;
            }
            else
            if(current < 0.75) {
                suffix = getString(R.string.battery_ok);
                color = Color.YELLOW;
            }
            else 
            if(current < 1.0){
                suffix = context.getString(R.string.battery_high);
                color = Color.GREEN;
            }
            else {
                suffix = context.getString(R.string.battery_full);
                color = Color.GREEN;
            }

            String status = String.format(getString(R.string.battery_is), suffix);
            mBattery.setText(status);
            mBattery.setTextColor(color);
        }
    }

}
