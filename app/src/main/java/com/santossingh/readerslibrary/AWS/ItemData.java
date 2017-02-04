package com.santossingh.readerslibrary.AWS;

/**
 * Created by santoshsingh on 04/02/17.
 */

public class ItemData {
    private String detailpageurl;

    public String getDetailpageurl() {
        return detailpageurl;
    }

    public void setDetailpageurl(String detailpageurl) {
        this.detailpageurl = detailpageurl;
    }

    @Override
    public String toString() {
        return "Buy Link" + detailpageurl;
    }
}
