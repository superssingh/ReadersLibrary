package com.santossingh.readerslibrary.AWS;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by santoshsingh on 05/02/17.
 */

public class GetAmazonURL {

    // Your AWS Access Key ID, as taken from the AWS Your Account page.
    private static final String AWS_ACCESS_KEY_ID = "AKIAILMCDWNHZ6OBN2QQ";
    // Your AWS Secret Key corresponding to the above ID, as taken from the AWS
    private static final String AWS_SECRET_KEY = "qWESYwVUgn2IcdHOmZZwK1xU3VcK98TxcRlQsEV2";
    //Use the end-point according to the region you are interested in.
    private static final String ENDPOINT = "webservices.amazon.in";

    //URL by ISBN
    public String getURLByISBN(String ISBN) {
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
        params.put("ResponseGroup", "Images,ItemAttributes,Reviews,Offers");
        params.put("IncludeReviewsSummary", "true");
        params.put("SearchIndex", "Books");

        return helper.sign(params);
    }

}
