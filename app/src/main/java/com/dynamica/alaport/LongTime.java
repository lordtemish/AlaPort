package com.dynamica.alaport;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

/**
 * Created by 17-n008ur on 29.09.2017.*/
 public class LongTime{
public  String carrier;
 public  String carreng;
 public String flight;
 public String aircrft;
 public String city;
 public Time timedepa;
 public Time timea;
 public String daysa;
 public Time begnav;
 public Time endnav;
 public Time bnavg;
 public Time enavg;
 public Time flighttime;
 public  LongTime(String s){
     String tagin="";
    try{
              XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
              factory.setNamespaceAware(true);
              XmlPullParser xpp=factory.newPullParser();

              xpp.setInput(new StringReader(s));
              int eventType=xpp.getEventType();

              while(eventType!=XmlPullParser.END_DOCUMENT){
                     if(eventType == XmlPullParser.START_TAG){
                     tagin=xpp.getName();
                     //  Log.d("tagin","HERE "+tagin);
                     }
                     else if(eventType==XmlPullParser.END_TAG){

                     }
                     else if(eventType==XmlPullParser.TEXT){
                     String qwe=xpp.getText();
                     if(qwe==null){
                     qwe=" ";
                     }
                     //Log.d(tagin,qwe+"");
                     if(tagin!=null)
                     switch (tagin){
                     case "CARRIER":
                     carrier=qwe;
                     break;
                     case "FLIGHT":
                     flight=qwe;
                     break;
                     case "AIRCRFT":
                     aircrft=qwe;
                     break;
                     case "TIMEDEPA":
                     timedepa=new Time("",qwe);
                     break;
                     case "TIMEARRD":
                     timea=new Time("",qwe);
                     break;
                         case "TIMED":
                             timedepa=new Time("",qwe);
                             break;
                     case "TIMEA":
                     timea=new Time("",qwe);
                     break;
                     case "DAYSA":
                     daysa=qwe;
                     break;case "DAYSD":
                     daysa=qwe;
                     break;
                     case "BEGNAV":
                     begnav=new Time(qwe.substring(0,10),"");
                     break;
                     case "ENDNAV":
                     endnav=new Time(qwe.substring(0,10),"");
                     break;
                     case "BNAVG":
                     bnavg=new Time(qwe.substring(0,10),"");
                     break;
                     case "ENAVG":
                     enavg=new Time(qwe.substring(0,10),"");
                     break;
                     case "FlightTime":
                     flighttime=new Time("",qwe);
                     break;
                     default:
                     //Log.d("AA",""+tagin+" "+qwe);
                     if(tagin.contains("CARR") && !tagin.equals("CARRIER")){
                     carreng=qwe;
                     }
                     if(tagin.contains("CITY")){
                     city=qwe;
                     }
                     break;
                     }
                     }
                     //Log.d("COunt this",xpp.getAttributeCount()+"");
                     eventType=xpp.next();
              }
    }
    catch(Exception e){
            e.printStackTrace();
    }
 }
 }
