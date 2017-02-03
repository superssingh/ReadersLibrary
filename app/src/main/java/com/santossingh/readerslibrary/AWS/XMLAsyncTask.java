package com.santossingh.readerslibrary.AWS;

import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by santoshsingh on 03/02/17.
 */

public class XMLAsyncTask extends AsyncTask<String, Void, String> {
    private static String fetchTitle(String requestUrl) {
        String title = null;
        try {
            Log.i("URL", requestUrl);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(requestUrl);
            Node titleNode = doc.getElementsByTagName("Item").item(0).getFirstChild();
            title = titleNode.getTextContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return title;
    }

    @Override
    protected String doInBackground(String... strings) {
        String xml = "Not Catched";
        try {
//            URL url = new URL(strings[0]);
            fetchTitle(strings[0]);

//            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//            DocumentBuilder db = dbf.newDocumentBuilder();
//            Document doc = db.parse(new InputSource(url.openStream()));
//            NodeList nodeList = doc.getElementsByTagName("items");
//            if (nodeList.item(0).hasAttributes()){
//                Log.i("has","Yes");
//            }else if(nodeList==null) {
//                Log.i("Not","No");
//            }else{
//                Log.i("has",nodeList.toString());
//            }

            /** Assign textview array lenght by arraylist size */

//            for (int i = 0; i < nodeList.getLength(); i++) {
//
//                Node node = nodeList.item(i);
//
//                Element fstElmnt = (Element) node;
//                NodeList nameList = fstElmnt.getElementsByTagName("item");
//                Element nameElement = (Element) nameList.item(0);
//                nameList = nameElement.getChildNodes();
//                Log.i("Name : ", (nameList.item(0)).getNodeValue());
//                xml=(nameList.item(0)).getNodeValue();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return xml;
    }
}
