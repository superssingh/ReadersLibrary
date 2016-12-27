package com.santossingh.readerslibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.santossingh.readerslibrary.Utilities.PDFTools;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
//        WebView myWebView = (WebView) findViewById(R.id.webview);
//        WebSettings webSettings = myWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
        Bundle intent = getIntent().getExtras();
//        String pdf =  intent.getString("ViewURL");
        String pdf = "http://books.google.co.in/books/download/The_Collected_Works_of_L_S_Vygotsky-sample-pdf.acsm?id=u8UTfKFWb5UC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api";
        String epub = " https://www.googleapis.com/books/v1/volumes?q=pride+prejudice&download=epub&key=";
        String APIkey = "4034208760-uiedq5l6q35r3ohkh5mtl4jhrl224l1u.apps.googleusercontent.com";
        String mypdf = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf";

        PDFTools.showPDFUrl(ViewActivity.this, pdf);
//        myWebView.loadUrl("https://google-developers.appspot.com/books/docs/viewer/"+ pdf);
//        myWebView.loadUrl(epub+APIkey);
    }
}
