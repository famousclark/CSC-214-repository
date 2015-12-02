package mobappdev.lecture23.talktomyself;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import mobappdev.lecture23.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TalkToMyselfFragment extends Fragment {
    private static final String ACTION_MESSAGE = "mobappdev.lecture23.action.MESSAGE";
    private static final String EXTRA_MESSAGE = "mobappdev.lecture23.message";


    private ReceiverOne mReceiverOne;
    private ReceiverTwo mReceiverTwo;
    private TextView mTvReceiverOne;
    private TextView mTvReceiverTwo;

    public TalkToMyselfFragment() {
        // Required empty public constructor
    }

    public static TalkToMyselfFragment newInstance() {
        return new TalkToMyselfFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_talk_to_myself, container, false);

        mReceiverOne = new ReceiverOne();
        mReceiverTwo = new ReceiverTwo();

        final EditText etMessage = (EditText)view.findViewById(R.id.edit_text_message);

        Button broadcast = (Button)view.findViewById(R.id.button_broadcast);
        broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_MESSAGE);
                intent.putExtra(EXTRA_MESSAGE, etMessage.getText().toString());
                getActivity().sendOrderedBroadcast(intent, null);
            }
        });

        CheckBox trapBroadcast = (CheckBox)view.findViewById(R.id.checkbox_trap_broadcast);
        mReceiverOne.shouldTrapIntent(trapBroadcast.isChecked());
        trapBroadcast.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mReceiverOne.shouldTrapIntent(isChecked);
            }
        });

        mTvReceiverOne = (TextView)view.findViewById(R.id.text_view_receiver_one);
        mTvReceiverTwo = (TextView)view.findViewById(R.id.text_view_receiver_two);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        getActivity().registerReceiver(mReceiverOne, mReceiverOne.getIntentFilter());
        getActivity().registerReceiver(mReceiverTwo, mReceiverTwo.getIntentFilter());
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().unregisterReceiver(mReceiverOne);
        getActivity().unregisterReceiver(mReceiverTwo);
    }

    private class ReceiverOne extends BroadcastReceiver {
        private boolean mTrap;

        public void shouldTrapIntent(boolean trap) {
            mTrap = trap;
        }

        public IntentFilter getIntentFilter() {
            IntentFilter filter = new IntentFilter(ACTION_MESSAGE);
            // must be lower than system high priority
            filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY - 1);
            return filter;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra(EXTRA_MESSAGE);
            mTvReceiverOne.setText(message);

            int resultCode;
            if(mTrap) {
                resultCode = Activity.RESULT_CANCELED;
            }
            else {
                resultCode = Activity.RESULT_OK;
            }
            setResultCode(resultCode);
        }
    }

    private class ReceiverTwo extends BroadcastReceiver {
        public IntentFilter getIntentFilter() {
            IntentFilter filter = new IntentFilter(ACTION_MESSAGE);
            // must be higher than system low priority
            filter.setPriority(IntentFilter.SYSTEM_LOW_PRIORITY + 1);
            return filter;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            int resultCode = getResultCode();
            if(resultCode != Activity.RESULT_CANCELED) {
                String message = intent.getStringExtra(EXTRA_MESSAGE);
                mTvReceiverTwo.setText(message);
            }
        }
    }

}
