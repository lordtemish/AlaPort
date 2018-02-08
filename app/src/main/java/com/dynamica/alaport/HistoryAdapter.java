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

/**
 * Created by 17-n008ur on 20.09.2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder>{
    ArrayList<ArrayList<String>> arrs;
    Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView year;
        TextView info;
        public MyViewHolder(View view){
            super(view);
            year=(TextView) view.findViewById(R.id.textView67);
            year.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/Avenir-Black.ttf"));
            info=(TextView) view.findViewById(R.id.textView68);
            info.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/AvenirNext-Medium.ttf"));
        }
    }
    HistoryAdapter(ArrayList<ArrayList<String>> a, Context c){
        arrs=a;context=c;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup groupm,int viewType){
        View itemView= LayoutInflater.from(groupm.getContext()).inflate(R.layout.his_row,groupm,false);
        return new MyViewHolder(itemView);
    }
    @Override
    public  void onBindViewHolder(MyViewHolder holder,final int position){
        String y=arrs.get(position).get(0);
        String in=arrs.get(position).get(1);
        holder.year.setText(y);
        holder.info.setText(in);
    }
    @Override
    public int getItemCount() {
        return arrs.size();
    }
}
