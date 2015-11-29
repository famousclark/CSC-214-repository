package mobappdev.lecture22.bowser;


import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import mobappdev.lecture22.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebBowserFragment extends Fragment {

    private ProgressBar mProgressBar;
    private WebView mWebView;
    private Button mGo;
    private EditText mUrl;

    public WebBowserFragment() {
        // Required empty public constructor
    }

    public static WebBowserFragment newInstance() {
        return new WebBowserFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_web_bowser, container, false);

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/mario.ttf");
        TextView webBowser = (TextView)view.findViewById(R.id.text_view_web_bowser);
        webBowser.setTypeface(typeface);

        mProgressBar = (ProgressBar)view.findViewById(R.id.progress_bar_bowser);
        mProgressBar.setMax(100);

        mWebView = (WebView)view.findViewById(R.id.web_view);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);
                    mGo.setEnabled(true);
                }
                else {
                    mGo.setEnabled(false);
                    mProgressBar.setVisibility(View.VISIBLE);
                    mProgressBar.setProgress(newProgress);
                }
            }
        });

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Uri uri = Uri.parse(url);
                String scheme = uri.getScheme();
                return (scheme.equalsIgnoreCase("http") == false &&
                    scheme.equalsIgnoreCase("https") == false);
            }
        });

        mUrl = (EditText)view.findViewById(R.id.edit_text_uri);

        mGo = (Button)view.findViewById(R.id.button_go);
        mGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = mUrl.getText().toString().toLowerCase();
                if(url.startsWith("http") == false) {
                    url = "http://" + url;
                }
                mWebView.loadUrl(url);
            }
        });

        return view;
    }

}
