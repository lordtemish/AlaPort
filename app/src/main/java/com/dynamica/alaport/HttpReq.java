package com.dynamica.alaport;

import android.util.Base64;
import android.util.Log;


import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by 17-n008ur on 06.08.2017.
 */

public class HttpReq {
    String link;
    HttpReq(String link){
        this.link=link;
    }
    public String make() {

        try {
            URL url=new URL(this.link);
            SAXParserFactory saxF=SAXParserFactory.newInstance();
            SAXParser sax=saxF.newSAXParser();
            return  "";

        } catch (Exception e) {
            return(e.getMessage());
        }
    }
}


