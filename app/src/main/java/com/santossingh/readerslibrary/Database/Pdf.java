package com.santossingh.readerslibrary.Database;

/**
 * Created by santoshsingh on 25/12/16.
 */

public class Pdf {
    private boolean isAvailable;
    private String acsTokenLink;

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getAcsTokenLink() {
        return this.acsTokenLink;
    }

    public void setAcsTokenLink(String acsTokenLink) {
        this.acsTokenLink = acsTokenLink;
    }
}