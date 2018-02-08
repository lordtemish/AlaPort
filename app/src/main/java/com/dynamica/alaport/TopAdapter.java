package com.dynamica.alaport;


import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dynamica.alaport.R;

import java.util.ArrayList;

/**
 * Created by 17-n008ur on 05.09.2017.
 */

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.MyViewHolder>{
    private ArrayList<Arrival> arrs;
    String lang="R";
    int aln_id, city_id, sts_id;
    boolean deps;
    String almat;
    Bundle bundle;
    Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder{
            TextView t1;
            TextView t2;
            TextView t3;
            TextView t4;
            TextView t5;
            TextView t6;
            ColorStateList colorgr;
            ImageView t14;
            RelativeLayout reltop;
        public MyViewHolder(View view) {
            super(view);
            t1 = (TextView) view.findViewById(R.id.textView3);
            t1.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/Avenir-Black.ttf"));
            t2 = (TextView) view.findViewById(R.id.textView4);
            t2.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/avenir-light.ttf"));
            t3 = (TextView) view.findViewById(R.id.textView17);
            t3.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/avenir-light.ttf"));
            colorgr=t3.getTextColors();
            t4 = (TextView) view.findViewById(R.id.textView6);
            t4.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/Avenir-Heavy.ttf"));
            t5 = (TextView) view.findViewById(R.id.textView5);
            t5.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/Avenir-Black.ttf"));
            t6 = (TextView) view.findViewById(R.id.textView18);
            t6.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/avenir-light.ttf"));
            t14=(ImageView) view.findViewById(R.id.imageView14);
            reltop=(RelativeLayout) view.findViewById(R.id.reltoprow);
        }
    }
    public TopAdapter(ArrayList<Arrival> arrivals, String s, boolean dep,Context context){
        arrs=arrivals;
        lang=s;
        this.context=context;
        deps=dep;
        switch (s){
            case "E":
                almat="ALMATY";
                aln_id=2;
                city_id=0;
                break;
            case "K":
                almat="АЛМАТЫ";
                aln_id=1;
                city_id=1;
                break;
            default:
                almat="АЛМАТЫ";
                aln_id=0;
                city_id=2;
                break;

        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.top_row, parent, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position){
        final Arrival arr=arrs.get(position);
        holder.t2.setText(arr.aln.get(aln_id));
        if(!deps){
            Log.d("transit",arr.transit+" "+arr.transitarrival);
            if(arr.transit){
                /*holder.t5.setText(arr.cities.get(city_id)+" | "+arr.transitarrival.cities.get(city_id));
                Log.d("adapter","works");*/
                Log.d("transit ", arr.cities.get(city_id));
                arr.cities.set(city_id,arr.cities.get(city_id)+" | "+arr.transitarrival.get(arr.transitarrival.size()-1).cities.get(city_id));
                /*arr.sch=arr.transitarrival.get(arr.transitarrival.size()-1).sch;
                arr.est=arr.transitarrival.get(arr.transitarrival.size()-1).est;
                arr.com=arr.transitarrival.get(arr.transitarrival.size()-1).com;*/
                arr.transit=false;
                arrs.set(position,arr);
            }
            holder.t5.setText(arr.cities.get(city_id));
            holder.t3.setText(almat);
        }
        else{
            if(arr.transit){
             /*   holder.t3.setText(arr.cities.get(city_id)+" | "+arr.transitarrival.cities.get(city_id));
                Log.d("adapter","works");*/
                arr.cities.set(city_id,arr.cities.get(city_id)+" | "+arr.transitarrival.get(arr.transitarrival.size()-1).cities.get(city_id));
                arr.transit=false;
            }
            holder.t3.setText(arr.cities.get(city_id));

            holder.t5.setTextColor(holder.colorgr);
            holder.t3.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/Avenir-Black.ttf"));
            holder.t5.setText(almat);
            holder.t5.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/avenir-light.ttf"));
            holder.t3.setTextColor(ColorStateList.valueOf(context.getResources().getColor(R.color.blueDrawer)));
        }

        holder.t4.setText(arr.typevs);
        if(arr.status.size()>2)
        holder.t6.setText(arr.status.get(city_id));
        holder.t1.setText(arr.sch.time);
        try{
            holder.t1.setText(arr.com.time);
        }
        catch (NullPointerException e){
            try{
                holder.t1.setText(arr.est.time);
            }
            catch (NullPointerException ee){
                //ee.printStackTrace();
            }
        }
        holder.reltop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,TicketActivity.class);
                intent.putExtra("aln",arr.aln.get(aln_id));
                if(arr.transitarrival.size()>0) {
                    if(!deps) {
                        intent.putExtra("city", arr.transitarrival.get(arr.transitarrival.size() - 1).cities.get(city_id));
                    }
                else{
                        intent.putExtra("city", arr.cities.get(city_id).split(" | ")[0]);
                    }
                }
                else
                intent.putExtra("city",arr.cities.get(city_id));

            //    Log.d("cittycheck",intent.getStringExtra("city")+" "+deps);
                intent.putExtra("datetime",""+arr.sch.getDate()+" / "+arr.sch.getTime());
                intent.putExtra("time",arr.sch.time);
                intent.putExtra("flt",arr.flt_nr);
                intent.putExtra("sts",arr.status.get(city_id));
                intent.putExtra("lang",lang);
                if(arr.transitarrival.size()>0){
                    intent.putExtra("transits", true);
                    String cities=arr.cities.get(city_id).split(" | ")[0];
                    for(int i=0;i<arr.transitarrival.size();i++){
                        cities+=" | "+arr.transitarrival.get(i).cities.get(city_id);
                    }
                    intent.putExtra("transitcities",cities);
                }
                else{
                    intent.putExtra("transits",false);
                }
                try{
                    intent.putExtra("est",arr.est.getDate()+" / "+arr.est.getTime());
                }
                catch (NullPointerException e){
                    e.printStackTrace();
                    intent.putExtra("est","");
                }
                try{
                    intent.putExtra("com",arr.com.getDate()+" / "+arr.com.getTime());
                }
                catch (NullPointerException e){
                    e.printStackTrace();
                    intent.putExtra("com","");
                }
                try{
                    if (!deps && arr.transitarrival.size()>0) {
                        intent.putExtra("flight_time",arr.transitarrival.get(arr.transitarrival.size()-1).flightT);
                    }
                    else {
                        intent.putExtra("flight_time", arr.flightT);
                    }
                }
                catch (NullPointerException e){
                    intent.putExtra("flight_time","");
                    e.printStackTrace();
                }
                intent.putExtra("typevs",arr.typevs);
                if(deps){
                    intent.putExtra("dep","dep");
                    intent.putExtra("checkin",arr.checkin);
                    intent.putExtra("gate",arr.gate);
                    intent.putExtra("cityeng","");
                }
                else{
                    intent.putExtra("dep","arr");
                    intent.putExtra("cityeng","almaty");
                }
                ((MainActivity)context).startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrs.size();
    }
}
