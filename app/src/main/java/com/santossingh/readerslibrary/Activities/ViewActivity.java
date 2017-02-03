package com.santossingh.readerslibrary.Activities;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import com.santossingh.readerslibrary.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.TOCReference;
import nl.siegmann.epublib.epub.EpubReader;

public class ViewActivity extends AppCompatActivity {

    WebView webview;
    String id, key, Preview;
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Bundle intent = getIntent().getExtras();

        AssetManager assetManager = getAssets();
        try {
            // find InputStream for book
            InputStream epubInputStream = assetManager.open("epub/book.epub");
            // Load Book from inputStream
            book = (new EpubReader()).readEpub(epubInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //For preview -----------
        id = intent.getString("ID");
        String url = "file:///android_asset/mypage.html";
        webview = (WebView) findViewById(R.id.webView);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDisplayZoomControls(true);
//        webview.setWebViewClient(new WebViewClient() {
//            public void onPageFinished(WebView view, String url) {
//                webview.loadUrl("javascript:initialize('" + id + "')");
//            }
//        });
//        webview.loadUrl(url);

//        String data = new String(book.getResources().toString());
//        webview.loadDataWithBaseURL(url, data, "text/html", "UTF-8", null);
    }

    public void epub() {
        AssetManager assetManager = getAssets();

        try {
            // find InputStream for book
            InputStream epubInputStream = assetManager.open("epub/book.epub");

            // Load Book from inputStream
            Book book = (new EpubReader()).readEpub(epubInputStream);
            Toast.makeText(this, book.toString(), Toast.LENGTH_LONG).show();
            // Log the book's authors
            Log.i("epublib", "author(s): " + book.getMetadata().getAuthors());

            // Log the book's title
            Log.i("epublib", "title: " + book.getTitle());

            // Log the book's coverimage property
            Bitmap coverImage = BitmapFactory.decodeStream(book.getCoverImage().getInputStream());
            Log.i("epublib", "Coverimage is " + coverImage.getWidth() + " by " + coverImage.getHeight() + " pixels");

            // Log the tale of contents
            logTableOfContents(book.getTableOfContents().getTocReferences(), 0);
        } catch (IOException e) {
            Log.e("epublib", e.getMessage());
        }
    }

    private void logTableOfContents(List<TOCReference> tocReferences, int depth) {
        if (tocReferences == null) {
            return;
        }
        for (TOCReference tocReference : tocReferences) {
            StringBuilder tocString = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                tocString.append("\t");
            }
            try {
                InputStream is = tocReference.getResource().getInputStream();
                BufferedReader r = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = r.readLine()) != null) {
                    line = Html.fromHtml(line).toString();
                }
            } catch (IOException e) {

            }
        }
    }

}
