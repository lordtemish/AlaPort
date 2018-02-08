package com.dynamica.alaport;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dynamica.alaport.R;

import java.util.ArrayList;

/**
 * Created by 17-n008ur on 20.09.2017.
 */

public class AlaportAdapter extends RecyclerView.Adapter<AlaportAdapter.MyViewHolder>{
    ArrayList<String> arrs;
    Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        RelativeLayout rl;
        public MyViewHolder(View view){
            super(view);
            rl=(RelativeLayout) view.findViewById(R.id.relAl);
            tv=(TextView) view.findViewById(R.id.textView66);
            tv.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/AvenirNext-Medium.ttf"));
        }
    }
    AlaportAdapter(ArrayList<String> a, Context con){
        arrs=a;context=con;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup groupm,int viewType){
        View itemView= LayoutInflater.from(groupm.getContext()).inflate(R.layout.alap_row,groupm,false);

        return new MyViewHolder(itemView);
    }
    @Override
    public  void onBindViewHolder(MyViewHolder holder,final int position){
        String s=arrs.get(position);
        holder.tv.setText(s);
        holder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,AlaportInfoActivity.class);
                intent.putExtra("number",position);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return arrs.size();
    }
}
