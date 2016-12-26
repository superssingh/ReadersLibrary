package com.santossingh.readerslibrary.Database;

/**
 * Created by santoshsingh on 25/12/16.
 */

public class AccessInfo {
    private String country;
    private String viewability;
    private boolean embeddable;
    private boolean publicDomain;
    private String textToSpeechPermission;
    private Epub epub;
    private Pdf pdf;
    private String webReaderLink;
    private String accessViewStatus;
    private boolean quoteSharingAllowed;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public void setViewability(String viewability) {
        this.viewability = viewability;
    }

    public String getViewability() {
        return this.viewability;
    }

    public void setEmbeddable(boolean embeddable) {
        this.embeddable = embeddable;
    }

    public boolean getEmbeddable() {
        return this.embeddable;
    }

    public void setPublicDomain(boolean publicDomain) {
        this.publicDomain = publicDomain;
    }

    public boolean getPublicDomain() {
        return this.publicDomain;
    }

    public void setTextToSpeechPermission(String textToSpeechPermission) {
        this.textToSpeechPermission = textToSpeechPermission;
    }

    public String getTextToSpeechPermission() {
        return this.textToSpeechPermission;
    }

    public void setEpub(Epub epub) {
        this.epub = epub;
    }

    public Epub getEpub() {
        return this.epub;
    }

    public void setPdf(Pdf pdf) {
        this.pdf = pdf;
    }

    public Pdf getPdf() {
        return this.pdf;
    }

    public void setWebReaderLink(String webReaderLink) {
        this.webReaderLink = webReaderLink;
    }

    public String getWebReaderLink() {
        return this.webReaderLink;
    }

    public void setAccessViewStatus(String accessViewStatus) {
        this.accessViewStatus = accessViewStatus;
    }

    public String getAccessViewStatus() {
        return this.accessViewStatus;
    }

    public void setQuoteSharingAllowed(boolean quoteSharingAllowed) {
        this.quoteSharingAllowed = quoteSharingAllowed;
    }

    public boolean getQuoteSharingAllowed() {
        return this.quoteSharingAllowed;
    }
}
