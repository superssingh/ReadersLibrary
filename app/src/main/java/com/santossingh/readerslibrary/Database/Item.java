package com.santossingh.readerslibrary.Database;

/**
 * Created by santoshsingh on 25/12/16.
 */

public class Item {
    private String kind;
    private String id;
    private String etag;
    private String selfLink;
    private VolumeInfo volumeInfo;
    private SaleInfo saleInfo;
    private AccessInfo accessInfo;
    private SearchInfo searchInfo;

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return this.kind;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getEtag() {
        return this.etag;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public VolumeInfo getVolumeInfo() {
        return this.volumeInfo;
    }

    public void setSaleInfo(SaleInfo saleInfo) {
        this.saleInfo = saleInfo;
    }

    public SaleInfo getSaleInfo() {
        return this.saleInfo;
    }

    public void setAccessInfo(AccessInfo accessInfo) {
        this.accessInfo = accessInfo;
    }

    public AccessInfo getAccessInfo() {
        return this.accessInfo;
    }

    public void setSearchInfo(SearchInfo searchInfo) {
        this.searchInfo = searchInfo;
    }

    public SearchInfo getSearchInfo() {
        return this.searchInfo;
    }
}
