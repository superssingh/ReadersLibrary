package com.santossingh.readerslibrary.Database;

/**
 * Created by santoshsingh on 25/12/16.
 */

public class ReadingModes {
    private boolean text;
    private boolean image;

    public void setText(boolean text) {
        this.text = text;
    }

    public boolean getText() {
        return this.text;
    }

    public void setImage(boolean image) {
        this.image = image;
    }

    public boolean getImage() {
        return this.image;
    }
}
