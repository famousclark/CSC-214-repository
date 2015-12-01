package mobappdev.lecture22.bowser;


import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import mobappdev.lecture22.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebBowserFragment extends Fragment {
    private static final String FONT = "fonts/mario_and_luigi.ttf";

    private ProgressBar mProgressBar;
    private WebView mWebView;
    private ImageButton mStop;
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

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), FONT);
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
                    mStop.setVisibility(View.GONE);
                }
                else {
                    mStop.setVisibility(View.VISIBLE);
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
        mUrl.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String url = mUrl.getText().toString();
                if(url.toLowerCase().startsWith("http") == false) {
                    url = "http://" + url;
                }
                mWebView.loadUrl(url);
                return true;
            }
        });

        mStop = (ImageButton)view.findViewById(R.id.button_stop);
        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.stopLoading();
            }
        });

        return view;
    }

    public boolean goBack() {
        boolean didGoBack = false;
        if(mWebView != null && mWebView.canGoBack()) {
            mWebView.goBack();
            didGoBack = true;
        }
        return didGoBack;
    }

}
