package com.android.locbookapp.ui.web;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.locbookapp.R;

public class WebViewActivity extends AppCompatActivity {

    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        wv = (WebView) findViewById(R.id.web_view);
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setLoadWithOverviewMode(true);
        ws.setUseWideViewPort(true);
        wv.setWebViewClient(new webclient());
        String s = getIntent().getStringExtra("url");
        wv.loadUrl(s);
    }
}
