package com.santossingh.readerslibrary.AWS;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by santoshsingh on 03/02/17.
 */

public class XMLPullParserHandler {

    private String text;

    public XMLPullParserHandler() {
    }

    public Void parse(InputStream is) { // pas the input stream
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser();

            parser.setInput(is, null);
            boolean check = false;

            //factory instantiates an object

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("image")) {
                            if (parser.getAttributeValue(null, "size").equals("extralarge")) {
                                check = true;
                            }
                        }

                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        String val = null;
                        if (tagname.equalsIgnoreCase("name")) {
                            val = text;
                            Log.i("", " name is " + val);
                        } else if (tagname.equalsIgnoreCase("mbid")) {
                            val = text;
                            Log.i("", " mbid is " + val);
                        } else if (tagname.equalsIgnoreCase("url")) {
                            val = text;
                            Log.i("", " url is " + val);
                        } else if (tagname.equalsIgnoreCase("image")) {
                            val = text;
                            if (check == true)
                                Log.i("", " image is " + val);
                        }

                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
