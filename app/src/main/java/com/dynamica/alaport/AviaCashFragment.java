package com.dynamica.alaport;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dynamica.alaport.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AviaCashFragment extends Fragment {
    public ImageView fphone;
    public ImageView sphone;

    public AviaCashFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_avia_cash, container, false);
        ArrayList<TextView> ts1=new ArrayList<>();
        ArrayList<TextView> ts2=new ArrayList<>();
        String tableNm="";
        TextView tabl=(TextView) view.findViewById(R.id.TableName);
        ts2.add((TextView)view.findViewById(R.id.textView24));
        ts2.add((TextView)view.findViewById(R.id.textView33));
        ts2.add((TextView)view.findViewById(R.id.textView35));
        ts2.add((TextView)view.findViewById(R.id.textView37));
        ts2.add((TextView)view.findViewById(R.id.textView54));
        ts2.add((TextView)view.findViewById(R.id.textView43));
        ts2.add((TextView)view.findViewById(R.id.textView45));
        ts2.add((TextView)view.findViewById(R.id.textView47));
        TextView t23=(TextView) view.findViewById(R.id.textView23);
        t23.setTextSize(12);
        ts1.add((TextView) view.findViewById(R.id.textView38));ts1.add((TextView) view.findViewById(R.id.textView32));ts1.add((TextView) view.findViewById(R.id.textView34));ts1.add((TextView) view.findViewById(R.id.textView36));ts1.add((TextView) view.findViewById(R.id.textView46));ts1.add((TextView) view.findViewById(R.id.textView48));ts1.add((TextView) view.findViewById(R.id.textView44));ts1.add((TextView) view.findViewById(R.id.textView55));ts1.add((TextView) view.findViewById(R.id.textView42));ts1.add((TextView) view.findViewById(R.id.textView25));
        for(TextView i : ts1){
            i.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Black.ttf"));
            i.setTextSize(10);
        }
        for(TextView i : ts2){
            i.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Heavy.ttf"));
            i.setTextSize(10);
        }
        t23.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        switch (((MainActivity)getActivity()).lang){
            case "E":
                t23.setText("Air and railway Tickets Booking and Sale.");//"Our company represents various types of touristic service-beach and excursion holiday, health resort treatment, sporting entertaining tours and offers different  tour package service: corporate holiday, individual and group tours, VIP supporting.");
                ts2.get(0).setText("Adress");
                ts2.get(1).setText("Phone");
                ts2.get(2).setText("Fax");
                ts2.get(3).setText("E-mail");
                ts2.get(4).setText("Adress");
                ts2.get(5).setText("Phone");
                ts2.get(6).setText("Fax");
                ts2.get(7).setText("E-mail");
                ts1.get(9).setText("City Air Terminal");
                ts1.get(1).setText("111, Zhibek Zholy st. \n Office №2");
                ts1.get(7).setText("Passenger Terminal");
                ts1.get(8).setText("2, B.Mailina st. ");
                tabl.setText("Ticket office");
                break;
            case "K":
                t23.setText("Авиаагенттік (ішкі және халықаралық рейстерге авиа және теміржол билеттерді сату және броньдау)");//"Біздің компания туристік қызметтердің әр түрін ұсынады – жағажайда және экскурсиялық демалыс, санатория-шипажайларда емделу, спорттық-ойын-сауық турлары және әртүрлі туристік пакеттер қызметін: корпоративтік демалыс, жеке және топтық турлар, VIP қызмет көрсетуді ұсынады.");
                ts2.get(0).setText("Мекен-жайы");
                ts2.get(4).setText("Мекен-жайы");
                ts2.get(3).setText("Эл. пошта");
                ts2.get(7).setText("Эл. пошта");
                ts1.get(9).setText("Қалалық Әуе Терминалы");
                ts1.get(1).setText("Жібек Жолы көш. 111\n кеңсе №2");
                ts1.get(7).setText("Алматы қаласы әуежайы");
                ts1.get(8).setText("Майлина көш. 2");
                tabl.setText("Авиакассалар");
                break;
            default:
                t23.setText("Бронирование и продажа авиа и железнодорожных билетов");
                break;
        }
        fphone=(ImageView)view.findViewById(R.id.imageView18);
        sphone=(ImageView)view.findViewById(R.id.imageView19);
        fphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).onCall("+77272584155");
            }
        });
        sphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).onCall("+77272703555");
            }
        });
        return view;
    }


}
