package com.dynamica.alaport;


import android.graphics.Color;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dynamica.alaport.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {
    RelativeLayout map;
    TextView first;
    TextView second;
    WebView wv;
    LinearLayout mapdrawer;
    FrameLayout fm;
    DrawerLayout dMap;
    RelativeLayout map1;
    RelativeLayout map2;
    ImageView mapicon;
    String t1,t2, floor1,floor2,mapName;
    TextView tableName;
    MapAdapter m11;
    MapAdapter m12;
    MapAdapter m21;
    MapAdapter m22;
    RecyclerView rvZone;
    RecyclerView rvObject;
    RecyclerView whole;
    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_map, container, false);
        map=(RelativeLayout) view.findViewById(R.id.maplinear);
     /*   map1=(RelativeLayout) view.findViewById(R.id.map1layout);
        map2=(RelativeLayout) view.findViewById(R.id.map2layout);*/
        mapicon=(ImageView) view.findViewById(R.id.imageView20);

        tableName=(TextView) view.findViewById(R.id.TableName);
        first=(TextView) view.findViewById(R.id.textView27);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFirst();
            }
        });
        second=(TextView) view.findViewById(R.id.textView26);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSecond();
            }
        });
        dMap=(DrawerLayout) view.findViewById(R.id.drawerMap);
        t1="file:///android_res/drawable/";
        t2="file:///android_res/drawable/map2.png";
        wv=(WebView) view.findViewById(R.id.mapView);wv.getSettings().setBuiltInZoomControls(true);
        wv.setBackgroundColor(Color.TRANSPARENT);
        wv.getSettings().setUseWideViewPort(true);
        wv.setInitialScale(-1);
        wv.loadDataWithBaseURL(t1,"<center><img src='map1.png' width='60%'/></center>","text/html","utf-8",null);
       // wv.loadData("<center><img src='"+t1+"map1.png' width='60%'/></center>","text/html",null);
        wv.getSettings().setDisplayZoomControls(false);

        mapicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dMap.openDrawer(whole);
            }
        });
        map.removeView(map2);

        whole=(RecyclerView) view.findViewById(R.id.wholeView);
        ArrayList<Integer> colors1=new ArrayList<>();
        ArrayList<Integer> colors2=new ArrayList<>();
        ArrayList<Integer> images1=new ArrayList<>();
        ArrayList<Integer> images2=new ArrayList<>();
        ArrayList<String>   names1=new ArrayList<>();
        ArrayList<String>   names2=new ArrayList<>();
        ArrayList<String>   names12=new ArrayList<>();
        ArrayList<String>   names22=new ArrayList<>();
        String razd,raspo;
        String name;
        switch (((MainActivity)getActivity()).lang){
            case "E":
                name="Airport map";
                names1.add("Зал вылета местных авиалиний");names1.add("Arrival of international airlines");names1.add("VIP arrival");names1.add("Transit lounge"); names1.add("Waiting room"); names1.add("Cafe");names1.add("Shops");names1.add("Airline office");names1.add("Cash desk");
                names2.add("Зал ожидания");names2.add("International airline check-in and passport control area");names2.add("International departure lounge");names2.add("Domestic check-in and departure lounge");names2.add("DutyFree Zone");names2.add("Cash desk");names2.add("Airline office");names2.add("Shops");names2.add("Cafes & restaurants");
                names12.add("Restaurants");names12.add("Cafe");names12.add("Stairs");names12.add("Luggage storage");names12.add("ATM");names12.add("Shops");names12.add("Mother & child room");names12.add("Information");names12.add("Luggage claim");names12.add("Currency exchange");
                names22.add("Check-in");names22.add("Restaurants");names22.add("Cafes");names22.add("Stairs");names22.add("Pharmacy");names22.add("ATM");names22.add("Shops");names22.add("Business lounge");names22.add("Information");names22.add("Luggage packing");names22.add("Currency exchange");
                razd="Division of zones";
                raspo="Location of objects";
                first.setText("1st Floor");
                second.setText("2nd Floor");
                break;
            case "K":
                name="Әуезжайдың жоспары";
                names1.add("Зал вылета местных авиалиний");names1.add("Халықаралық әуе желілерінің ұшып келуі");names1.add("ВИП ұшып келу");names1.add("Транзиттік зал"); names1.add("Транзиттік зал"); names1.add("Дәмхана");names1.add("Дүкендер");names1.add("Өкілдіктер");names1.add("Кассалар");
                names2.add("Зал ожидания");names2.add("Халықаралық әуе желілерін тіркеу және паспорттық бақылау аймағы");names2.add("Халықаралық әуе желілерінің  ұшып шығу залы");names2.add("Жергілікті әуе желілерін тіркеу және ұшып шығу залы");names2.add("DutyFree аймағы");names2.add("Кассалар");names2.add("Әуе/компания өкілдіктері");names2.add("Дүкендер");names2.add("Дәмхана, мейрамханалар");
                names12.add("Мейрамханалар");names12.add("Дәмхана");names12.add("Баспалдақтар");names12.add("Сақтау камерасы");names12.add("Банкоматтар");names12.add("Дүкен");names12.add("Ана мен бала бөлмесі");names12.add("Анықтама");names12.add("Жүк өткізу");names12.add("Валюта айырбастау");
                names22.add("Тіркеу");names22.add("Мейрамханалар");names22.add("Дәмхана");names22.add("Баспалдақтар");names22.add("Дәріхана");names22.add("Банкоматтар");names22.add("Дүкен");names22.add("Бизнес залы");names22.add("Анықтама");names22.add("Жүк өткізу");names22.add("Валюта айырбастау");
                razd="Аумақтарды бөлу";
                raspo="Нысандардың орналасуы";
                first.setText("1 Қабат");
                second.setText("2 Қабат");
                break;
            default:
                name="План аэропорта";
                names1.add("Зал вылета местных авиалиний");names1.add("Прилет международных авиалиний");names1.add("VIP прилет");names1.add("Транзитный зал"); names1.add("Зал ожидания"); names1.add("Кафе");names1.add("Магазины");names1.add("Представительства");names1.add("Кассы");
                names2.add("Зал ожидания");names2.add("Зона регистрации и паспортного контроля международных авиалиний");names2.add("Зал вылета международных авиалиний");names2.add("Зал регистрации и вылета местных авиалиний");names2.add("Зона DutyFree");names2.add("Кассы");names2.add("Представительства а/к");names2.add("Магазины");names2.add("Кафе, Рестораны");
                names12.add("Рестораны");names12.add("Кафе");names12.add("Лестницы");names12.add("Камера хранения");names12.add("Банк, банкоматы");names12.add("Магазин");names12.add("Комната матери и ребенка");names12.add("Справка");names12.add("Выдача багажа");names12.add("Обмен валюты");
                names22.add("Регистрация");names22.add("Рестораны");names22.add("Кафе");names22.add("Лестницы");names22.add("Аптека");names22.add("Банк, банкоматы");names22.add("Магазин");names22.add("Бизнес зал");names22.add("Справка");names22.add("Выдача багажа");names22.add("Обмен валюты");
                razd="Разделение зон";
                raspo="Расположение объектов";
                break;
        }
        tableName.setText(name);
        colors1.add(R.color.map11);colors1.add(R.color.map12);colors1.add(R.color.map13);colors1.add(R.color.map14);colors1.add(R.color.map15);colors1.add(R.color.map16);colors1.add(R.color.map17);colors1.add(R.color.map18);colors1.add(R.color.map19);
        colors2.add(R.color.map21);colors2.add(R.color.map22);colors2.add(R.color.map23);colors2.add(R.color.map24);colors2.add(R.color.map25);colors2.add(R.color.map26);colors2.add(R.color.map27);colors2.add(R.color.map28);colors2.add(R.color.map29);

        images1.add(R.drawable.m121);images1.add(R.drawable.m122);images1.add(R.drawable.m123);images1.add(R.drawable.m124);images1.add(R.drawable.m125);images1.add(R.drawable.m126);images1.add(R.drawable.m127);images1.add(R.drawable.m128);images1.add(R.drawable.m129);images1.add(R.drawable.m1210);
        images2.add(R.drawable.m221);images2.add(R.drawable.m222);images2.add(R.drawable.m223);images2.add(R.drawable.m224);images2.add(R.drawable.m225);images2.add(R.drawable.m226);images2.add(R.drawable.m227);images2.add(R.drawable.m228);images2.add(R.drawable.m229);images2.add(R.drawable.m2210);images2.add(R.drawable.m1210);

        m11=new MapAdapter(colors1,names1,images1,names12,true, razd,raspo);
        m12=new MapAdapter(colors2,names2,images2,names22,true,razd,raspo);

        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity());
        RecyclerView.LayoutManager mLayoutManager1=new LinearLayoutManager(getActivity());
        whole.setLayoutManager(mLayoutManager);
        whole.setItemAnimator(new DefaultItemAnimator());
        whole.setAdapter(m11);
        whole.addItemDecoration(new DividerItemDecoration(whole.getContext(),DividerItemDecoration.HORIZONTAL));
    /*    rvZone.setLayoutManager(mLayoutManager);
        rvZone.setItemAnimator(new DefaultItemAnimator());
        rvZone.setAdapter(m11);
        rvZone.addItemDecoration(new DividerItemDecoration(rvZone.getContext(),
                DividerItemDecoration.HORIZONTAL));*/

        return view;
    }
    public void Back(){
        if(dMap.isDrawerOpen(whole)) {
            dMap.closeDrawer(whole);
        }
        else{
            ((MainActivity)getActivity()).Back();
        }
    }
    public void setFirst(){
        wv.loadDataWithBaseURL(t1,"<center><img src='map1.png' width='60%'/></center>","text/html","utf-8",null);
        first.setTextColor(getResources().getColor(R.color.whity));
        second.setTextColor(getResources().getColor(R.color.greyy));
        whole.setAdapter(m11);
    }
    public void setSecond(){
        wv.loadDataWithBaseURL(t1,"<center><img src='maplast.png' width='60%'/></center>","text/html","utf-8",null);
        second.setTextColor(getResources().getColor(R.color.whity));
        first.setTextColor(getResources().getColor(R.color.greyy));
        whole.setAdapter(m12);
    }
}
