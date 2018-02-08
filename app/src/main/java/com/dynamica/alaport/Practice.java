package com.dynamica.alaport;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.*;
import java.io.*;
import java.util.ArrayList;


public class Practice{
    String link;
    public String wid="807c54f238c0e9d37c595bfa31d85462";
    public Practice(String link){
        this.link=link;
    }
    public String getXml()throws Exception{
        URL url=new URL(link);
        URLConnection yc=url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String xml="";
        String inputline;
        while((inputline=in.readLine())!= null){
            xml+=inputline;
        }
        in.close();
        return xml;
    }
    public String weatherXml(String city) throws Exception{
      /*  String[] cities=("Abu Dhabi ABU DHABI\n" +
                "Aktau AKTAU\n" +
                "Aktobe AKTOBE\n" +
                "Amman AMMAN\n" +
                "Antalya ANTALYA\n" +
                "Astana ASTANA\n" +
                "Atyrau ATYRAU\n" +
                "Amsterdam AMSTERDAM\n" +
                "Ashhabat ASHGABAT\n" +
                "Baku BAKU\n" +
                "Balhash BALKHASH\n" +
                "Bangkok BANGKOK\n" +
                "Batumi BATUMI\n" +
                "Beirut BEIRUT\n" +
                "Bishkek BISHKEK\n" +
                "Bodrum BODRUM\n" +
                "Borispol BORISPOL\n" +
                "Bratsk BRATSK\n" +
                "Budapest BUDAPEST\n" +
                "Warsaw WARSAW\n" +
                "Hong_Kong HONG KONG\n" +
                "Guangzhou GUANGZHOU\n" +
                "Dalyan DALIAN\n" +
                "Delhi NEW DELHI\n" +
                "Jeddah JEDDAH\n" +
                "Doha DOHA\n" +
                "Dubai DUBAI\n" +
                "Dushanbe DUSHANBE\n" +
                "Yekaterinburg EKATERINBURG\n" +
                "Zhezqazghan ZHEZKAZGAN\n" +
                "Geneve GENEVA\n" +
                "Gerona GERONA\n" +
                "Issyk-Kul ISSIK KUL\n" +
                "kazan KAZAN\n" +
                "Kabul KABUL\n" +
                "Qaraghandy KARAGANDA\n" +
                "Kiev KIEV\n" +
                "KOSTANAY KOSTANAY\n" +
                "Kokshetau KOKSHETAU\n" +
                "Kuala_Lumpur KUALA-LUMPUR\n" +
                "Qyzylorda KYZYLORDA\n" +
                "Leipzig LEIPZIG\n" +
                "London LONDON\n" +
                "Luxembourg LUXEMBOUR\n" +
                "Manama MANAMA\n" +
                "Medina MADINAH\n" +
                "Minsk MINSK\n" +
                "Moscow MOSCOW / SVO\n" +
                "Napoli NAPLES\n" +
                "Nice NICE\n" +
                "Novosibirsk NOVOSIBIRSK\n" +
                "Pavlodar PAVLODAR\n" +
                "Paris PARIS\n" +
                "Bejing BEIJING/PEKING\n" +
                "Saloniki THESSALONIKI\n" +
                "Semey SEMEY\n" +
                "Seoul SEOUL\n" +
                "Saint_Petersburg ST-PETERSBURG\n" +
                "Istanbul ISTANBUL\n" +
                "Xiamen XIAMEN\n" +
                "Xian XI AN XIANYA\n" +
                "Taldyqorghan TALDYKORGAN\n" +
                "Tampere TAMPERE\n" +
                "Tashkent TASHKENT\n" +
                "Tbilisi TBILISI\n" +
                "Tehran TEHRAN\n" +
                "Tel_Aviv TEL AVIV\n" +
                "Tianjin TIANJIN\n" +
                "Oral URALSK\n" +
                "Urzhar URZHAR\n" +
                "Urunchi URUMQI\n" +
                "Ust-Kamenogorsk UST-KAMENOGORSK\n" +
                "Farnborough FARNBOROUGH\n" +
                "Frankfurt FRANKFURT\n" +
                "Thanh_pho_Ho_Chi_Minh HO CHI MINH\n" +
                "Zurich ZURICH\n" +
                "Chengdu CHENGDU\n" +
                "Shanghai SHANGHAI\n" +
                "Sharjah SHARJAH\n" +
                "Shymkent SHYMKENT\n" +
                "Sochi ADLER/SOCHI\n" +
                "Sharm ash Shaykh SHARM EL SHEIKH\n" +
                "Almaty ALMATY\n" +
                "Athens ATHENS\n" +
                "Bosteri TAMCHY\n" +
                "Samara SAMARA\n" +
                "Goa GOA\n" +
                "Cuneo KUNEO\n" +
                "Sanya SANYA\n" +
                "Petropavlovsk PETROPAVLOVSK\n" +
                "Petropavlovsk PETROPAVLOVSK\n" +
                "Male MALE\n" +
                "Krabi KRABI\n" +
                "Rayong UTAPAO\n" +
                "Surat_Thani SURAT THANI\n" +
                "Ahmadabad AHMEDABAD\n" +
                "Phuket PHUKET\n" +
                "Cam_Ranh KAMRAN").split("\n");
        for(int i=0;i<cities.length;i++){
            if(cities[i].contains(city.split(" ")[0])){
                city=cities[i].split(" ")[0];
                if(city.contains("_")){
                    city=city.substring(0,city.indexOf("_"))+" "+city.substring(city.indexOf("_")+1,city.length());
                }
                Log.d("PRACTICE",city);
                break;
            }
        }*/
        URL url=new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&mode=xml&appid="+wid);
        URLConnection yc=url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String xml="";
        String inputline;
        while((inputline=in.readLine())!= null){
            xml+=inputline;
        }
        in.close();
        return xml;
    }
}
/*class Arrival{
    String id;
    ArrayList<String> aln=new ArrayList<>();
    String flt_nr;
    String cityId;
    ArrayList<String> cities=new ArrayList<>();
    Time sch;
    Time est;
    Time com;
    String checkin="";
    ArrayList<String> status=new ArrayList<>();
    ArrayList<String> rsn=new ArrayList<>();
    String trafic;
    String typevs;
    Arrival(String s){
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
                                sch=new Time(qwe,"");
                            }
                            else if(tagin.equals("sch_tm")){
                                sch=new Time(sch.getDate(),qwe);
                            }
                            else if(tagin.equals("est_dt")){
                                est=new Time(qwe,"");
                            }
                            else if(tagin.equals("est_tm")){
                                est=new Time(est.getDate(),qwe);

                            }
                            else if(tagin.equals("com_dt")){
                                com=new Time(qwe,"");
                            }
                            else if(tagin.equals("com_tm")){
                                com=new Time(com.getDate(),qwe);

                            }
                            else if(tagin.equals("sts_en") || tagin.equals("sts_ru") || tagin.equals("sts_kz")){
                                status.add(qwe);
                                if(status.size()==3 && tagin.equals("sts_kz")){
                                    String aa=status.get(0);
                                    status.remove(0);
                                    status.add(aa);
                                }
                            }
                            else if(tagin.equals("trfc")){
                                trafic=qwe;
                            }
                            else if(tagin.equals("type_vs")){
                                typevs=qwe;
                            }
                            else if(tagin.equals("check_in_desk")){
                                checkin=qwe;
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
*/
