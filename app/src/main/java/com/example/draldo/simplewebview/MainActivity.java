package com.example.draldo.simplewebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextview;
    private EditText mEditText;
    private WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextview = (TextView) findViewById(R.id.main_txt);
        mEditText = (EditText) findViewById(R.id.main_et);
        mWebview = (WebView) findViewById(R.id.main_web);
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.addJavascriptInterface(new WebAppInterface(mTextview),"Android");
    }

    public void doMagic(View view) {
        String url = mEditText.getText().toString();
        mWebview.loadUrl(url);
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });
    }
}
