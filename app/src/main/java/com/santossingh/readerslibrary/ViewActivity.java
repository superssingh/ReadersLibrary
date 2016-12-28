package com.santossingh.readerslibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewActivity extends AppCompatActivity {

    WebView webview;
    String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Bundle intent = getIntent().getExtras();
        key = "ISBN:" + intent.getString("ISBN");
        String download = "http://books.google.co.in/books/download/The_Child_s_Own_Story_Book.pdf?id=9WevWtW5KMUC&hl=&output=pdf&sig=ACfU3U0LWT7WWnfdtxAFbBctZk4aALv8gA&source=gbs_api";
        String url = "file:///android_asset/mypage.html";
        webview = (WebView) findViewById(R.id.webView);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDisplayZoomControls(true);
        webview.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                webview.loadUrl("javascript:initialize('" + key + "')");
            }
        });
        webview.loadUrl(url);
    }
}
