package com.riis.HelloGoogle;

/**
 * Created by SD on 3/15/16.
 */

import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;
import android.os.Bundle;

public class WebViewActivity extends ActionBarActivity{

    private WebView webView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.google.com");
    }
}
