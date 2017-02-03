package com.santossingh.readerslibrary.Activities;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.santossingh.readerslibrary.AWS.SignedRequestsHelper;
import com.santossingh.readerslibrary.AWS.XMLAsyncTask;
import com.santossingh.readerslibrary.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {

    // Your AWS Access Key ID, as taken from the AWS Your Account page.
    private static final String AWS_ACCESS_KEY_ID = "AKIAILMCDWNHZ6OBN2QQ";
    // Your AWS Secret Key corresponding to the above ID, as taken from the AWS
    private static final String AWS_SECRET_KEY = "qWESYwVUgn2IcdHOmZZwK1xU3VcK98TxcRlQsEV2";
    //Use the end-point according to the region you are interested in.
    private static final String ENDPOINT = "webservices.amazon.in";

    private static final String AWS_TAG = "superssingh-21";
    InputStream stream = null;
    private ViewDataBinding binding;
    private XmlPullParserFactory xmlFactoryObject = null;
    private XmlPullParser myparser;
    private String requestUrl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        requestUrl = getURL();
        XMLAsyncTask xmlAsyncTask = new XMLAsyncTask();
        xmlAsyncTask.execute(requestUrl);
//        Log.i("URL", requestUrl);
    }

    public String getURL() {
        SignedRequestsHelper helper;

        try {
            helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

        Map<String, String> params = new HashMap<String, String>();

        params.put("Service", "AWSECommerceService");
        params.put("Operation", "ItemSearch");
        params.put("AWSAccessKeyId", "AKIAILMCDWNHZ6OBN2QQ");
        params.put("AssociateTag", "superssingh-21");
        params.put("SearchIndex", "Books");
        params.put("ResponseGroup", "ItemAttributes");
        params.put("Title", "four Hour work week");

        return helper.sign(params);
    }

    public void downloadXML(String s) {
        URL url = null;
        try {
            url = new URL(s);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            byte buffer[] = new byte[5000];

            int count;
            String xmlData = "";
            while ((count = in.read(buffer)) != -1) {
                xmlData += new String(buffer, 0, count);
            }

            urlConnection.disconnect();

            Log.d("Data", " Data: " + xmlData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}