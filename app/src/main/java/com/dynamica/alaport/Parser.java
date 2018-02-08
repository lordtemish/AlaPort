package com.dynamica.alaport;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by 17-n008ur on 29.09.2017.
 */

public class Parser{
    HashSet<String> set;
    HashMap<String,Arrival> map1;
    public Parser(){
        set=new HashSet<>();
        map1=new HashMap<>();
    }

    public ArrayList<Arrival> ArrParsing(String s){
        ArrayList<Arrival> arrs=new ArrayList<>();
        String ss="";
        boolean get=false;
        if(s!=null) {
            try {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(true);
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(new StringReader(s));
                int eventType = xpp.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_DOCUMENT) {

                    }
                    else if (eventType == XmlPullParser.START_TAG) {
                        if(xpp.getName().equals("row")){
                            get=true;
                        }
                        if(get){
                            ss+="<"+xpp.getName()+">";
                        }
                        // Log.d("ASDASDADS", "Start tag " + xpp.getName() );
                    } else if (eventType == XmlPullParser.END_TAG) {
                        if(get){
                            ss+="</"+xpp.getName()+">";
                        }
                        if(xpp.getName().equals("row")){
                            get=false;
                            Arrival arr=new Arrival(ss);
                          //  Log.d("CHECKPARSER",arr.flt_nr+" "+arr.sch.getDate());
                            map1.put(arr.flt_nr+" "+arr.sch.getDate(),arr);
                            ss="";
                            arrs.add(arr);
                            if(arrs.size()>1)
                            if(arrs.get(arrs.size()-1).flt_nr.equals(arrs.get(arrs.size()-2).flt_nr)){
                                arrs.get(arrs.size()-2).transitarrival.add(arrs.get(arrs.size()-1));
                                arrs.get(arrs.size()-2).transit=true;
                                Log.d("transit Avia","+++");
                                arrs.remove(arrs.size()-1);
                            }
                        }
                        //Log.d("ASDASDADS", "End tag " + xpp.getName());
                    } else if (eventType == XmlPullParser.TEXT) {
                        if(get){
                            ss+=xpp.getText();
                        }
                        //  Log.d("ASDASDADS", "Text " + xpp.getText());
                    }

                    eventType = xpp.next();
                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{

        }

        return arrs;
    }
    public ArrayList<String> ar(String lang, String xml){
        ArrayList<String> array=new ArrayList<>();
        DecimalFormat df=new DecimalFormat("#.#");
        if(xml!=null || xml!=""){
            try{
                XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(true);
                XmlPullParser xpp=factory.newPullParser();

                xpp.setInput(new StringReader(xml));
                int eventtype=xpp.getEventType();
                while(eventtype!= XmlPullParser.END_DOCUMENT){
                    switch (eventtype){
                        case XmlPullParser.START_DOCUMENT:

                            break;
                        case XmlPullParser.START_TAG:
                            Log.d("temp",xpp.getName());
                            if(xpp.getName().equals("temperature")){
                                Log.d("temp",(int)((Double.parseDouble(xpp.getAttributeValue(0)))-273.15)+" C");
                                array.add((int)((Double.parseDouble(xpp.getAttributeValue(0)))-273.15)+"");
                            }
                            else if(xpp.getName().equals("weather")){
                                Log.d("temp",xpp.getAttributeValue(1));
                                array.add(xpp.getAttributeValue(1));
                            }
                            else if(xpp.getName().equals("city")){
                                Log.d("citytemp",xpp.getAttributeValue(1));
                            }
                            break;
                    }
                    if(array.size()>=2){
                        break;
                    }
                    eventtype=xpp.next();
                }
            }
            catch (XmlPullParserException e){
                e.printStackTrace();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return array;
    }
    public ArrayList<LongTime> LongParsing(String s){
        ArrayList<LongTime> arrs=new ArrayList<>();
        String ss="";
        boolean get=false;
        if(s!=null) {
            try {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(true);
                XmlPullParser xpp = factory.newPullParser();

                xpp.setInput(new StringReader(s));
                int eventType = xpp.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_DOCUMENT) {
                        // Log.d("ASDASDADS", "Start document");
                    } else if (eventType == XmlPullParser.START_TAG) {
                        if(xpp.getName().equals("row")){
                            get=true;
                        }
                        if(get){
                            ss+="<"+xpp.getName()+">";
                        }
                        // Log.d("ASDASDADS", "Start tag " + xpp.getName() );
                    } else if (eventType == XmlPullParser.END_TAG) {
                        if(get){
                            ss+="</"+xpp.getName()+">";
                            if(xpp.getName().equals("FlightTime"))
                                Log.d("ASDA",xpp.getName());
                        }
                        if(xpp.getName().equals("row")){
                            get=false;
                            LongTime arr=new LongTime(ss);
                            set.add(arr.city);
                            ss="";
                            arrs.add(arr);
                        }
                        //Log.d("ASDASDADS", "End tag " + xpp.getName());
                    } else if (eventType == XmlPullParser.TEXT) {
                        if(get){
                            ss+=xpp.getText();
                        }
                        //  Log.d("ASDASDADS", "Text " + xpp.getText());
                    }

                    eventType = xpp.next();
                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{

        }
        return arrs;
    }

}
