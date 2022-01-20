package com.csu.web2app;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// class is extended to WebViewClient to access the WebView
public class WebViewController extends WebViewClient {

    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request, Context context) {
        if ("google.com".equals(request.getUrl().getHost())) {
			// This is my website, so do not override; let my WebView load the page
            return false;
        }
        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
        Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
        context.startActivity(intent);
        return true;
    }

}
