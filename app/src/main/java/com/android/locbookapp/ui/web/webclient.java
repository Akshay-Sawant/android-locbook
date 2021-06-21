package com.android.locbookapp.ui.web;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webclient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}