package com.santossingh.readerslibrary.AWS;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by santoshsingh on 03/02/17.
 */

public class XMLAsyncTask extends AsyncTask<String, Void, String> {

    // Your AWS Access Key ID, as taken from the AWS Your Account page.
    private static final String AWS_ACCESS_KEY_ID = "AKIAILMCDWNHZ6OBN2QQ";
    // Your AWS Secret Key corresponding to the above ID, as taken from the AWS
    private static final String AWS_SECRET_KEY = "qWESYwVUgn2IcdHOmZZwK1xU3VcK98TxcRlQsEV2";
    //Use the end-point according to the region you are interested in.
    private static final String ENDPOINT = "webservices.amazon.in";


    @Override
    protected String doInBackground(String... strings) {
        String buyURL = "";
        try {
            String xml = getURL(strings[0]);

            InputStream stream = downloadUrl(xml);

            XMLPullParserHandler xmlPullParserHandler = new XMLPullParserHandler();
            buyURL = xmlPullParserHandler.parse(stream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return buyURL;
    }

    public String getURL(String ISBN) {
        SignedRequestsHelper helper;

        try {
            helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

        Map<String, String> params = new HashMap<String, String>();

        params.put("Service", "AWSECommerceService");
        params.put("Operation", "ItemLookup");
        params.put("AWSAccessKeyId", "AKIAILMCDWNHZ6OBN2QQ");
        params.put("AssociateTag", "superssingh-21");
        params.put("ItemId", ISBN);
        params.put("IdType", "ISBN");
        params.put("ResponseGroup", "Images,ItemAttributes,Offers");
        params.put("IncludeReviewsSummary", "true");
        params.put("SearchIndex", "Books");

        return helper.sign(params);
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

}
