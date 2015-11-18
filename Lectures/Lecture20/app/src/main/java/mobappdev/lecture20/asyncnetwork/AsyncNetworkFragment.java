package mobappdev.lecture20.asyncnetwork;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import mobappdev.lecture20.HttpHelper;
import mobappdev.lecture20.R;


public class AsyncNetworkFragment extends Fragment {

    private TextView mMessage;

    public AsyncNetworkFragment() {
        // Required empty public constructor
    }

    public static AsyncNetworkFragment newInstance() {
        return new AsyncNetworkFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_async_network, container, false);

        mMessage = (TextView)view.findViewById(R.id.text_view_output);

        final EditText url = (EditText)view.findViewById(R.id.edit_text_url);
        Button get = (Button)view.findViewById(R.id.button_get_url);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetUrlTask().execute(url.getText().toString());
            }
        });

        return view;
    }


    private class GetUrlTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... params) {
            String result;
            try {
                result = new HttpHelper().getString(params[0]);
            }
            catch(IOException ioe) {
                result = "IO Error: " + ioe.getMessage();
            }
            mMessage.setText(result);
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            String display = ( s.length() > 100 ? s.substring(0,100) : s );
            mMessage.setText(display);
        }
    }
}
