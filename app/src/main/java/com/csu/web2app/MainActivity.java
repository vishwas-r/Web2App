package com.csu.web2app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class MainActivity extends Activity {

    private WebView webView;
    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.web_view_home);

        WebSettings webSettings = webView.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setMinimumFontSize(1);
        webSettings.setMinimumLogicalFontSize(1);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setSaveFormData(false);
        webSettings.setSavePassword(false);

        webView.setWebViewClient(new WebViewController(){
            @Override
            public void onReceivedSslError(final WebView view, final SslErrorHandler handler, final SslError error) {
                handler.proceed();
            }
        });

        webView.loadUrl(getString(R.string.web_url));
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}