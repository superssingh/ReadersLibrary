package com.santossingh.readerslibrary.Database;

/**
 * Created by santoshsingh on 25/12/16.
 */

public class SaleInfo {
    private String country;
    private String saleability;
    private boolean isEbook;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    public String getSaleability() {
        return this.saleability;
    }

    public void setIsEbook(boolean isEbook) {
        this.isEbook = isEbook;
    }

    public boolean getIsEbook() {
        return this.isEbook;
    }
}
