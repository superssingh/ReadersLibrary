package com.santossingh.readerslibrary.AWS;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by santoshsingh on 03/02/17.
 */

public class XMLPullParserHandler {

    private final String ITEM_TAG = "item";
    private final String DETAIL_PAGE_URL = "detailpageurl";

    List<ItemData> itemData;
    private ItemData buylink;
    private String text;

    public XMLPullParserHandler() {
        itemData = new ArrayList<ItemData>();
    }

    public String parse(InputStream is) {
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser();

            parser.setInput(is, null);

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase(ITEM_TAG)) {
                            // create a new instance of ItemData
                            buylink = new ItemData();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase(ITEM_TAG)) {
                            // add ItemData object to list
                            itemData.add(buylink);
                        } else if (tagname.equalsIgnoreCase(DETAIL_PAGE_URL)) {
                            buylink.setDetailpageurl(text);
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

        return itemData.get(0).getDetailpageurl();
    }
}
