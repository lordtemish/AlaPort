package com.dynamica.alaport;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dynamica.alaport.R;

import java.util.ArrayList;

/**
 * Created by 17-n008ur on 30.09.2017.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.MyViewHolder> {
    ArrayList<String> cities;
    Context context;

    String lang;
    RaspFragment raspFragment;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv5;
        RelativeLayout reltop;
        public MyViewHolder(View view) {
            super(view);
            tv5=(TextView) view.findViewById(R.id.textView5);
            reltop=(RelativeLayout) view.findViewById(R.id.reltoprow);
        }
    }
    public CityAdapter(ArrayList<String> cities, String s, boolean dep, RaspFragment raspFragment) {
        this.cities=cities;
        lang=s;
        this.raspFragment=raspFragment;
    }
    @Override
    public CityAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_row, parent, false);
        context=parent.getContext();
        return new CityAdapter.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final CityAdapter.MyViewHolder holder, final int position) {
        String s=cities.get(position);
        holder.tv5.setText(s);
        holder.reltop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                raspFragment.setCity(holder.tv5.getText()+"");

            }
        });
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }
}
