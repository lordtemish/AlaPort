package com.dynamica.alaport;

/**
 * Created by 17-n008ur on 29.09.2017.
 */
public class Notificat{
    public  String flt,date, time, city;
    public int before;
    public  long timmillis;
    boolean deps;
    public Notificat(String flt, String date, String time, int before, String city, long timmillis, boolean dep){
        this.flt=flt;
        this.date=date;
        this.time=time;
        this.before=before;
        this.city=city;
        this.timmillis=timmillis;
        deps=dep;
    }
}