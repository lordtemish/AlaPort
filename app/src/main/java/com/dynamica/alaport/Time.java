package com.dynamica.alaport;

/**
 * Created by 17-n008ur on 28.08.2017.
 */

public class Time{
    public  String date="";
    public  String time="";
    public Time(String d){
        date=d;
    }
    public Time(String d, String t){
        date=d;
        time=t;
    }
    public void setTime(String t){
        time=t;
    }
    public String getDate(){
        return date;
    }    public String getTime(){return time;}
    public String dateMinus(String s, int a){
        int hour=Integer.parseInt(s.substring(0,2));
        int minute=Integer.parseInt(s.substring(3,5));
        minute-=a;
        String min,hou;
        if(minute<0){
            hour--;
            minute+=60;
        }
        if(hour<0){
            hour+=24;
        }
        hou=hour+"";
        min=minute+"";
        if(hou.length()<2){
            hou=0+hou;
        }
        if(min.length()<2){
            min=0+min;
        }

        return hou+":"+min;
    }
}