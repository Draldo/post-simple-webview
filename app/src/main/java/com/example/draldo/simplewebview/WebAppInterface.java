package com.example.draldo.simplewebview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.TextView;

/**
 * Created by Draldo on 12/09/2016.
 */
public class WebAppInterface {

    TextView mTextView;

    WebAppInterface(TextView tv){
        mTextView = tv;
    }

    @JavascriptInterface
    public void changeText(){
        mTextView.setText("Hello Aldo! This message is from the web view");
    }
}
