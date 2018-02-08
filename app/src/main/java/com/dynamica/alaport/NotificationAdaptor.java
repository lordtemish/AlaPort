package com.dynamica.alaport;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dynamica.alaport.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by 17-n008ur on 05.09.2017.
 */

public class NotificationAdaptor extends RecyclerView.Adapter<NotificationAdaptor.MyViewHolder>{
    private ArrayList<Notificat> arrs;
    String lang="R";
    String flt,date, time, city, almat;
    int before,aln_id, city_id;
    long timmillis;
    Bundle bundle;
    Context context;
    String er1,er2;
    boolean con;
    HashMap<String,Arrival> aa;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView t1;
        TextView t2;
        TextView t3;
        TextView t4;
        TextView t5;
        TextView t6;
        ImageView t14;
        RelativeLayout reltop;
        public MyViewHolder(View view) {
            super(view);
            t1 = (TextView) view.findViewById(R.id.textView3);
            t1.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/Avenir-Black.ttf"));
            t3 = (TextView) view.findViewById(R.id.textView17);
            t3.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/AvenirNext-Medium.ttf"));
            t5 = (TextView) view.findViewById(R.id.textView5);
            t5.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/AvenirNext-Medium.ttf"));
            t6 = (TextView) view.findViewById(R.id.textView18);
            t6.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/avenir-light.ttf"));
            t2=(TextView) view.findViewById(R.id.textView151);
            t2.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/avenir-light.ttf"));
            t14=(ImageView) view.findViewById(R.id.imageView56);
            reltop=(RelativeLayout) view.findViewById(R.id.reltoprow);
        }
    }
    public NotificationAdaptor(ArrayList<Notificat> notificats, String s, Context context, boolean con, HashMap<String, Arrival> a){
        arrs=notificats;
        lang=s;
        aa=a;
        this.con=con;
        this.context=context;
        switch (s){
            case "E":
                almat="ALMATY";
                aln_id=2;
                city_id=0;
                er1="Connection trouble";
                er2="No such flight in the table";
                break;
            case "K":
                almat="АЛМАТЫ";
                aln_id=1;
                city_id=1;
                er1="Ғаламтор жоқ";
                er2="Бұл рейс тізімде жоқ";
                break;
            default:
                almat="АЛМАТЫ";
                aln_id=0;
                city_id=2;
                er1="Проблемы соеденения";
                er2="Нет такого рейса в таблице";
                break;

        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.not_row, parent, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position){
        final Notificat arr1=arrs.get(position);
        Time time=new Time("","");
        holder.t5.setText(almat);
        holder.t3.setText(arr1.city);
        holder.t1.setText(arr1.time);
        holder.t6.setText(arr1.date);
        holder.t2.setText(time.dateMinus(arr1.time,arr1.before));
        if(Calendar.getInstance().getTimeInMillis()>arr1.timmillis){
            holder.t14.setImageResource(R.drawable.notbell2);
        }
        else{
            holder.t14.setImageResource(R.drawable.notbell);
        }
        holder.reltop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("CHECK",arr1.flt+" "+arr1.date+" "+aa.containsKey(arr1.flt+" "+arr1.date));
                if(aa.containsKey(arr1.flt+" "+arr1.date)) {
                    if(con) {
                        Intent intent = new Intent(context, TicketActivity.class);
                        Arrival arr = aa.get(arr1.flt+" "+arr1.date);
                        intent.putExtra("aln", arr.aln.get(aln_id));
                        intent.putExtra("city", arr.cities.get(city_id));
                        intent.putExtra("datetime", "" + arr.sch.getDate() + " / " + arr.sch.getTime());
                        intent.putExtra("time", arr.sch.time);
                        intent.putExtra("flt", arr.flt_nr);
                        intent.putExtra("sts", (arr.status.get(city_id) + ""));
                        intent.putExtra("lang", lang);
                        try {
                            intent.putExtra("est", arr.est.getDate() + " / " + arr.est.getTime());
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                            intent.putExtra("est", "");
                        }
                        try {
                            intent.putExtra("com", arr.com.getDate() + " / " + arr.com.getTime());
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                            intent.putExtra("com", "");
                        }
                        try{
                            intent.putExtra("flight_time",arr.flightT);
                        }
                        catch (NullPointerException e){
                            intent.putExtra("flight_time","");
                            e.printStackTrace();
                        }
                        intent.putExtra("typevs", arr.typevs);
                        if (arr1.deps) {
                            intent.putExtra("dep", "dep");
                            intent.putExtra("checkin", arr.checkin);
                            intent.putExtra("gate",arr.gate);
                        } else {
                            intent.putExtra("dep", "arr");
                        }

                            context.startActivity(intent);

                    }
                    else{
                            Toast.makeText(context,er1,Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                        Toast.makeText(context,er2,Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrs.size();
    }
}
