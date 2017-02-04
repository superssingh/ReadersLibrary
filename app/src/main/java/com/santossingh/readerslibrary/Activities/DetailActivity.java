package com.santossingh.readerslibrary.Activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.santossingh.readerslibrary.AWS.GetAmazonURL;
import com.santossingh.readerslibrary.AWS.XMLPullParserHandler;
import com.santossingh.readerslibrary.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DetailActivity extends AppCompatActivity {

    XMLPullParserHandler xmlPullParserHandler;
    GetAmazonURL getAmazonURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getAmazonURL = new GetAmazonURL();
        xmlPullParserHandler = new XMLPullParserHandler();

        new XmlAsync().execute("9780191647581");

    }

    private InputStream downloadUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000); /* milliseconds */
        conn.setConnectTimeout(15000); /* milliseconds */
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        // Starts the query
        conn.connect();
        return conn.getInputStream();
    }

    private class XmlAsync extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String data = null;
            String url = getAmazonURL.getURLByISBN(strings[0]);
            try {
                InputStream inputStream = new BufferedInputStream(downloadUrl(url));
                data = xmlPullParserHandler.parse(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("***BuyFromAmazonLink-", s);
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
        }
    }

}