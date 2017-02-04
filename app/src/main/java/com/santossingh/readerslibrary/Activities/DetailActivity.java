package com.santossingh.readerslibrary.Activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.santossingh.readerslibrary.AWS.XMLAsyncTask;
import com.santossingh.readerslibrary.AWS.XMLPullParserHandler;
import com.santossingh.readerslibrary.R;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DetailActivity extends AppCompatActivity {

    InputStream inputStream = null;
    XMLAsyncTask xmlAsyncTask;
    XMLPullParserHandler xmlPullParserHandler;
    private String requestUrl = null;

    private static String fetchTitle(String requestUrl) {
        String title = "ASDFG";
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(requestUrl);
            Node titleNode = doc.getElementsByTagName("detailpageurl").item(0);
            title = titleNode.getTextContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return title;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        xmlAsyncTask = new XMLAsyncTask();
        xmlPullParserHandler = new XMLPullParserHandler();

        new XmlAsync().execute("9780191647581");
//        listView = (ListView) findViewById(R.id.list);

//        List<ItemData> itemData = null;
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
            String url = xmlAsyncTask.getURL(strings[0]);
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
            Log.i("**********RESULT-", s);
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
        }
    }

}