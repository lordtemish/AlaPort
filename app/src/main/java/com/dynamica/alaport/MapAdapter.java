package com.dynamica.alaport;


import android.content.Context;
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
 * Created by 17-n008ur on 25.09.2017.
 */

public class MapAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<Integer> arrs;
    private ArrayList<Integer> arrs1;
    private ArrayList<String> strings;
    private ArrayList<String> strings1;
    boolean color;
    Bundle bundle;
    Context context;
    String razd,rasp;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text1;
        ImageView col1;
        RelativeLayout reltop;
        public MyViewHolder(View view) {
            super(view);
            text1=(TextView) view.findViewById(R.id.colorName);
            col1=(ImageView) view.findViewById(R.id.colorView);
            reltop=(RelativeLayout) view.findViewById(R.id.reltoprow);
        }
    }
    public class FirstViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public FirstViewHolder(View view) {
            super(view);
            tv=(TextView) view.findViewById(R.id.text1);
        }
    }
    public MapAdapter(ArrayList<Integer> ids,ArrayList<String> names,ArrayList<Integer> ids1,ArrayList<String> names1, boolean color, String razd, String rasp){
        arrs=ids;
        arrs1=ids1;
        strings=names;
        strings1=names1;
        this.rasp=rasp;
        this.razd=razd;
        Log.d("FUCKK",rasp+" "+razd);
        this.color=color;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        switch (viewType) {
            case 1:
                View itemView1 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.text_row, parent, false);
                return new MapAdapter.FirstViewHolder(itemView1);
            default:
                View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.map_row, parent, false);
                context = parent.getContext();
                return new MapAdapter.MyViewHolder(itemView);
        }
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder1, final int position){
        Log.d("pos",position+"");
        if(getItemViewType(position)==1){
            FirstViewHolder holder=(FirstViewHolder) holder1;
                if(position==0){
                    holder.tv.setText(razd);
                }
                else{
                    holder.tv.setText(rasp);
                }
        }
        else {
            if(position>arrs.size()){
                final int arr= arrs1.get(position-1-arrs.size());
                final String name = strings1.get(position-1-arrs.size());
                MyViewHolder holder=(MyViewHolder) holder1;
                holder.text1.setText(name);
                holder.col1.setBackground(context.getResources().getDrawable(arr));
            }
            else {
                final int arr = arrs.get(position);
                final String name = strings.get(position);
                MyViewHolder holder=(MyViewHolder) holder1;
                holder.text1.setText(name);
                holder.col1.setBackgroundColor(context.getResources().getColor(arr));

            }
        }
    }

    @Override
    public int getItemCount() {
        return arrs.size()+arrs1.size()+1;
    }
    @Override
    public int getItemViewType(int position){
        if(position==0 || position==arrs.size()){
            return 1;
        }
        else{
            return 0;
        }
    }
}

