package com.santossingh.readerslibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import java.io.File;

public class ViewActivity extends AppCompatActivity {

    WebView webview;
    String id, key, download;
    File file = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Bundle intent = getIntent().getExtras();
        download = intent.getString("downloadPDF");
        key = "ISBN:" + intent.getString("ISBN");
        id = intent.getString("ID");
        String link = "http://maven.apache.org/maven-1.x/maven.pdf";


//        PDFTools p=new PDFTools();
//        p.showPDFUrl(this,link);
//        String url = "file:///android_asset/mypage.html";
//        webview = (WebView) findViewById(R.id.webView);
//        webview.getSettings().setJavaScriptEnabled(true);
//        webview.getSettings().setDisplayZoomControls(true);
//        webview.setWebViewClient(new WebViewClient() {
//            public void onPageFinished(WebView view, String url) {
//                webview.loadUrl("javascript:initialize('" + id + "')");
//            }
//        });
//        webview.loadUrl(url);
    }

}
