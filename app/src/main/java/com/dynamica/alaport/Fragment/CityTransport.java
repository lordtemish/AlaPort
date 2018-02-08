package com.dynamica.alaport.Fragment;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dynamica.alaport.HealthyInfoActivity;
import com.dynamica.alaport.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CityTransport extends Fragment{
    public RelativeLayout rel;
    ArrayList<TextView> tvs;
    int[] a={
            R.id.textView111,
            R.id.textView148,
            R.id.textView149,
            R.id.textView150,
            R.id.textView152
    };
    WebView wv;
    String inf;
    ImageView iv56;
    String t1;
    public LinearLayout allmarsh;
    public RelativeLayout resultmap;
    TextView tv;
    LinearLayout m79;
    LinearLayout m86;
    LinearLayout m92;
    LinearLayout m106;

    public CityTransport() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inf="0";
        View view=inflater.inflate(R.layout.fragment_city_transport, container, false);
        rel=(RelativeLayout) view.findViewById(R.id.marshLayout);
        //iv56=(ImageView) view.findViewById(R.id.imageView56);
        String s="file:///android_res/drawable/marsh.png";
        t1="file:///android_res/drawable/";
        tvs=new ArrayList<>();
        for(int i=0;i<5;i++){
            tvs.add((TextView) view.findViewById(a[i]));
            tvs.get(i).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Heavy.ttf"));
        }
        wv=(WebView) view.findViewById(R.id.webView);
        wv.getSettings().setBuiltInZoomControls(true);

        wv.setBackgroundColor(Color.TRANSPARENT);
        wv.getSettings().setUseWideViewPort(true);
        wv.setInitialScale(1);
        wv.clearCache(true);
        wv.getSettings().setDisplayZoomControls(false);
        wv.loadDataWithBaseURL(t1,"<center><img src='marsh.png' width='90%'/></center>","text/html","utf-8",null);
        allmarsh=(LinearLayout) view.findViewById(R.id.allmarsh);
        resultmap=(RelativeLayout) view.findViewById(R.id.resultmap);
        tv=(TextView) view.findViewById(R.id.textView146);
        m79=(LinearLayout) view.findViewById(R.id.marsh79);
        m79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearAndSet("79");
            }
        });
        ((LinearLayout) view.findViewById(R.id.marsh16)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backset();
            }
        });
        m86=(LinearLayout) view.findViewById(R.id.marsh86);
        m86.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearAndSet("86");
            }
        });
        m92=(LinearLayout) view.findViewById(R.id.marsh92);
        m92.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearAndSet("92");
            }
        });
        m106=(LinearLayout) view.findViewById(R.id.marsh106);
        m106.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearAndSet("106");
            }
        });
        rel.removeAllViews();
        rel.addView(allmarsh);
        setLang(((HealthyInfoActivity)getActivity()).lang);
        return view;
    }
    public void setUrl(String s){
        wv.loadDataWithBaseURL(t1,"<center><img src='"+s+"' width='90%'/></center>","text/html","utf-8",null);
    }
    public void setLang(String s){
        switch (s){
            case "E":
                for(TextView i:tvs){
                    i.setText("Route");
                }
                break;
            case "K":
                for(TextView i:tvs){
                    i.setText("Бағыт");
                }
                break;
        }
    }
    public void clearAndSet(String s) {
        rel.removeAllViews();
        rel.addView(resultmap);
        tv.setText(s);
        switch (s){
            case "96":

                break;
            default:

        }
    }
    public void backset(){
        rel.removeAllViews();
        rel.addView(allmarsh);
    }


}
