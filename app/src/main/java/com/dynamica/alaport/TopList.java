package com.dynamica.alaport;


import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dynamica.alaport.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by 17-n008ur on 01.09.2017.
 */

public class TopList extends RecyclerView.Adapter<TopList.MyViewHolder>{
    Context con;
    String lang;
    Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView aln;
        TextView almaty;
        TextView city;
        TextView flt_nr;
        TextView year;
        TextView weekRasp, RaspAr, RaspDep;
        ArrayList<TextView> weekDays;
        ArrayList<TextView> dates;
        ArrayList<TextView> arrs;
        ArrayList<TextView> deps;
        public MyViewHolder(View view) {
            super(view);
            weekDays=new ArrayList<>();dates=new ArrayList<>();arrs=new ArrayList<>();deps=new ArrayList<>();
            weekRasp=(TextView) view.findViewById(R.id.t21);
            RaspAr=(TextView) view.findViewById(R.id.t22);
            RaspDep=(TextView) view.findViewById(R.id.t23);
            aln=(TextView) view.findViewById(R.id.t1);
            aln.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/avenir-light.ttf"));
            almaty=(TextView) view.findViewById(R.id.t2);
            almaty.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/Avenir-Heavy.ttf"));
            city=(TextView) view.findViewById(R.id.t4);
            city.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/avenir-light.ttf"));
            year=(TextView) view.findViewById(R.id.t6);
            year.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/AvenirNext-Medium.ttf"));
            flt_nr=(TextView) view.findViewById(R.id.t5);
            weekDays.add((TextView) view.findViewById(R.id.t7));weekDays.add((TextView) view.findViewById(R.id.t8));weekDays.add((TextView) view.findViewById(R.id.t9));weekDays.add((TextView) view.findViewById(R.id.t10));weekDays.add((TextView) view.findViewById(R.id.t11));weekDays.add((TextView) view.findViewById(R.id.t12));weekDays.add((TextView) view.findViewById(R.id.t13));
            dates.add((TextView) view.findViewById(R.id.t14));dates.add((TextView) view.findViewById(R.id.t15));dates.add((TextView) view.findViewById(R.id.t16));dates.add((TextView) view.findViewById(R.id.t17));dates.add((TextView) view.findViewById(R.id.t18));dates.add((TextView) view.findViewById(R.id.t19));dates.add((TextView) view.findViewById(R.id.t20));
            arrs.add((TextView) view.findViewById(R.id.t41));arrs.add((TextView) view.findViewById(R.id.t42));arrs.add((TextView) view.findViewById(R.id.t43));arrs.add((TextView) view.findViewById(R.id.t44));arrs.add((TextView) view.findViewById(R.id.t45));arrs.add((TextView) view.findViewById(R.id.t46));arrs.add((TextView) view.findViewById(R.id.t47));
            deps.add((TextView) view.findViewById(R.id.t51));deps.add((TextView) view.findViewById(R.id.t52));deps.add((TextView) view.findViewById(R.id.t53));deps.add((TextView) view.findViewById(R.id.t54));deps.add((TextView) view.findViewById(R.id.t55));deps.add((TextView) view.findViewById(R.id.t56));deps.add((TextView) view.findViewById(R.id.t57));
        }
    }
    public ArrayList<LongTime> data;
    public TopList(ArrayList<LongTime> item, String lang, Context context){
        data=item;
        this.lang=lang;
        this.context=context;
    }
    @Override
    public TopList.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.long_row, parent, false);
        con=parent.getContext();
        return new TopList.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(TopList.MyViewHolder holder, int position){
        LongTime arr=data.get(position);
        Calendar calendar= GregorianCalendar.getInstance();
        calendar.setTimeZone(TimeZone.getDefault());
        holder.aln.setText(arr.carreng);
        holder.almaty.setText("ALMATY");
        holder.city.setText(arr.city);
        holder.flt_nr.setText(arr.flight);
        int day=calendar.get(Calendar.DAY_OF_WEEK);
        holder.year.setText(arr.begnav.getDate()+" - "+arr.endnav.getDate());
        switch (lang){
            case "E":
                holder.weekDays.get(0).setText("Mo");
                holder.weekDays.get(1).setText("Tu");
                holder.weekDays.get(2).setText("We");
                holder.weekDays.get(3).setText("Th");
                holder.weekDays.get(4).setText("Fr");
                holder.weekDays.get(5).setText("Sa");
                holder.weekDays.get(6).setText("Su");
                holder.weekRasp.setText("Week schedule");
                holder.RaspAr.setText("Arrivals");
                holder.RaspDep.setText("Departures");
                break;
            case "K":
                holder.weekDays.get(0).setText("Дс");
                holder.weekDays.get(1).setText("Сс");
                holder.weekDays.get(2).setText("Ср");
                holder.weekDays.get(3).setText("Бс");
                holder.weekDays.get(4).setText("Жм");
                holder.weekDays.get(5).setText("Сн");
                holder.weekDays.get(6).setText("Жк");
                holder.weekRasp.setText("Аптаға кестесі");
                holder.RaspAr.setText("Ұшып келу");
                holder.RaspDep.setText("Ұшып кету");
                break;
        }
        switch (day){
            case Calendar.SUNDAY:
                setDate(6,calendar,holder.dates);
                break;
            case Calendar.MONDAY:
                setDate(0,calendar,holder.dates);
                break;
            case Calendar.TUESDAY:
                setDate(1,calendar,holder.dates);
                break;
            case Calendar.WEDNESDAY:
                setDate(2,calendar,holder.dates);
                break;
            case Calendar.THURSDAY:
                setDate(3,calendar,holder.dates);
                break;
            case Calendar.FRIDAY:
                setDate(4,calendar,holder.dates);
                break;
            case Calendar.SATURDAY:
                setDate(5,calendar,holder.dates);
                break;
        }
        for(int i=0;i<7;i++){
            if(arr.daysa.substring(i,i+1).equals(".")){
                holder.arrs.get(i).setBackgroundResource(0);
                holder.arrs.get(i).setText("");
                holder.deps.get(i).setText("");
                holder.deps.get(i).setBackgroundResource(0);
            }
            else{

                    holder.arrs.get(i).setText(arr.timea.getTime());
                    holder.arrs.get(i).setBackgroundResource(R.drawable.rounded_timein);

                holder.deps.get(i).setText(arr.timedepa.getTime());
                holder.deps.get(i).setBackgroundResource(R.drawable.rounded_timeout);

            }
        }
    }
    public void setDate(int day, Calendar cal,ArrayList<TextView> tv){
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd");
        for(int i=0;i<7;i++){
            Calendar calendar=Calendar.getInstance();
            if(i==day){
                tv.get(i).setText(sdf.format(calendar.getTime()));
                tv.get(i).setTextColor(con.getResources().getColor(R.color.goodorange));
            }
            else{
                calendar.add(Calendar.DATE,i-day);
                tv.get(i).setText(sdf.format(calendar.getTime()));
            }
        }
    }
    public LongTime findByFlight(ArrayList<LongTime> a, String f){
        for(LongTime i:a){
            if(i.flight.equals(f)){
                return i;
            }
        }
        return null;
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
}
