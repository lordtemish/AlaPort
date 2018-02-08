package com.dynamica.alaport;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class Arrival{
    public String id;
    public ArrayList<String> aln=new ArrayList<>();
    public String flt_nr;
    public String cityId;
    public ArrayList<String> cities=new ArrayList<>();
    public Time sch;
    public Time est;
    public Time com;
    public String checkin="";
    public ArrayList<String> status=new ArrayList<>();
    public ArrayList<String> rsn=new ArrayList<>();
    public String trafic;
    public String typevs;
    public String gate="";
    public String flightT;
    public boolean transit=false;
    public ArrayList<Arrival> transitarrival;
    public Arrival(String s){
        transitarrival=new ArrayList<>();
        String tagin="";
        if(s!=null){
            try {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(true);
                XmlPullParser xpp = factory.newPullParser();

                xpp.setInput(new StringReader(s));
                int eventType = xpp.getEventType();
                while(eventType != XmlPullParser.END_DOCUMENT){
                    if (eventType == XmlPullParser.START_TAG) {
                        tagin=xpp.getName();
                        //  Log.d("ASDASDADS", "Start tag " + xpp.getName() );
                    } else if (eventType == XmlPullParser.END_TAG) {

                        // Log.d("ASDASDADS", "End tag " + xpp.getName());
                    } else if (eventType == XmlPullParser.TEXT) {
                        if(!tagin.equals("")){
                            String qwe=xpp.getText();
                            if(qwe.equals(null)){
                                qwe="";
                            }
                            if(tagin.equals("aln_id")){
                                id=qwe;
                            }
                            else if(tagin.equals("aln_en") || tagin.equals("aln_kz") || tagin.equals("aln_ru")){
                                aln.add(qwe);
                            }
                            else if(tagin.equals("flt_nr")){
                                flt_nr=qwe;
                            }
                            else if(tagin.equals("cty_id")){
                                cityId=qwe;
                            }
                            else if(tagin.equals("cty_en") || tagin.equals("cty_ru") || tagin.equals("cty_kz")){
                                cities.add(qwe);
                            }
                            else if(tagin.equals("sch_dt")){
                                sch=new Time(qwe);
                            }
                            else if(tagin.equals("sch_tm")){
                                sch.setTime(qwe);
                            }
                            else if(tagin.equals("est_dt")){
                                est=new Time(qwe);
                            }
                            else if(tagin.equals("est_tm")){
                                est.setTime(qwe);
                            }
                            else if(tagin.equals("com_dt")){
                                com=new Time(qwe);
                            }
                            else if(tagin.equals("com_tm")){
                                com.setTime(qwe);
                            } else if (tagin.equals("gate")) {
                                gate=qwe;
                            } else {
                                if (tagin.equals("sts_en") || tagin.equals("sts_ru") || tagin.equals("sts_kz")) {
                                    status.add(qwe);
                                    if (status.size() == 3 && tagin.equals("sts_kz")) {
                                        String aa = status.get(0);
                                        status.remove(0);
                                        status.add(aa);
                                    }
                                } else if (tagin.startsWith("Status")) {
                                    if (status.size() < 3) {
                                        if (qwe.length() > 1) {
                                            status.add(qwe);

                                        }

                                        if (tagin.endsWith("Rus")) {

                                        } else if (tagin.endsWith("Eng")) {

                                        } else if (tagin.endsWith("Kaz")) {
                                            if (status.size() == 3 || status.get(2) == qwe) {
                                                String aa = status.get(0);
                                                status.remove(0);
                                                status.add(aa);
                                            }
                                            for (int i = 0; i < 3; i++) {
                                                Log.d("STATUS" + i, status.get(i));
                                            }
                                        }
                                    }
                                } else if (tagin.equals("trfc")) {
                                    trafic = qwe;
                                } else if (tagin.equals("type_vs")) {
                                    typevs = qwe;
                                } else if (tagin.equals("check_in_desk")) {
                                    checkin = qwe;
                                } else if (tagin.equals("flight_time")) {
                                    flightT = qwe;
                                }
                            }
                            tagin="";
                        }
                        //Log.d("ASDASDADS", "Text " + xpp.getText());
                    }

                    eventType = xpp.next();
                }
            }
            catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            Log.d("NULL FUCKING STRING", "true");
        }
    }
    public String getInfo(){
        String s=id+" ";
        for(String i:aln){
            s+=i+" ";
        }
        s+=flt_nr+" ";
        try {
            s += (est.getDate() == null) + " ";
            s += est.getTime() + " ";
        }
        catch (NullPointerException e){
            s+=false+" ";
        }
        return s;
    }
}
