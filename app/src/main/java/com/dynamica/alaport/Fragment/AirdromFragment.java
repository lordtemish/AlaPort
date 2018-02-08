package com.dynamica.alaport.Fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dynamica.alaport.AlaportInfoActivity;
import com.dynamica.alaport.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AirdromFragment extends Fragment {
    TextView tv102,tv103,tv105,tv88,tv89,tv90,tv91,tv92,tv106,tv107;

    public AirdromFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_airdrom, container, false);
        tv102=(TextView) view.findViewById(R.id.textView102);tv102.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv103=(TextView) view.findViewById(R.id.textView103);tv103.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Heavy.ttf"));
        tv105=(TextView) view.findViewById(R.id.textView105);tv105.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv106=(TextView) view.findViewById(R.id.textView106);tv106.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Heavy.ttf"));
        tv107=(TextView) view.findViewById(R.id.textView107);tv107.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv88=(TextView) view.findViewById(R.id.textView88);tv88.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv89=(TextView) view.findViewById(R.id.textView89);tv89.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv90=(TextView) view.findViewById(R.id.textView90);tv90.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv91=(TextView) view.findViewById(R.id.textView91);tv91.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv92=(TextView) view.findViewById(R.id.textView92);tv92.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        setLang(((AlaportInfoActivity)getActivity()).lang);
        return view;
    }
    public void setLang(String s){
        switch (s){
            case "K":
                tv102.setText("Аэроалаң қызметі ұшу алаңын, перрон, және ӘК арналған тұрақтарды әуе кемелерінің ұшуын, қонуын, жүргізуін қамтамасыз ету үшін үнемі дайындықта ұстау бойынша шаралар кешенін жүзеге асырады");
                tv103.setText("Аэроалаң аумағының жалпы көлемі 4 589 731 ш.м. құрайды.");
                tv105.setText("Оның ішінде:");
                tv88.setText("ҰҚЖ алаңы – 563 000,00");
                tv89.setText("РЖ жолағы – 128 250,00");
                tv90.setText("ТО алаңы, жолдар, қызметтік аумақтар – 628 421,00");
                tv91.setText("грунтталған жер алаңы – 3 270 000,00");
                tv92.setText("тұрақ және Әкорналасу орындарына арналған алаң – 154 721,00");
                tv106.setText("Әуежайда 2 ұшу/қону жолағы бар:\n\n біріншісі – ұзындығы 4400м х 60м\nекіншісі – 4500м х 60м.");
                tv107.setText("Екінші ҰҚЖ 2008 жылы салынған. Бұл жолақ ИКАО халықаралық стандарттары бойынша 3В санатына сәйкес жарықсигналды жүйесімен жабдықталған. 05L/23R ҰҚЖ Орта Азиядағы ең ұзын жолақ болып саналады және әлемнің 20 ең ұзын ҰҚЖ топтамасына кіреді.\n" + "1998 жылы АВВ фирмасының жаңа жарық сигналды жүйесі орнатылған: бұл жүйе арқылы әуе кемелері ұшу, қону және жылжу жұмыстарын орындайды, олар: СМК-232- ICAO ІІ санаты бойынша, метеоминимум; СМК-52- ICAO І санаты бойынша.\n" + "2011 жылғы желтоқсан айында Мемлекетаралық авиациялық комитетінің мамандар тобы ICAO III B санатында ұшуға арналған аэроалаң сертификатын тапсырды\n");
                break;
            case "E":
                tv102.setText("The Aerodrome Service carries out a package of measures maintaining the airfield, apron, and parking stands for aircraft in instant operational readiness for aircraft taking-off, landing, taxiing, and parking.");
                tv103.setText("The total area of the aerodrome pavement is 4 589 731 731 sq.m.");
                tv105.setText("including:");
                tv88.setText("Runway area is - 563 000,00");
                tv89.setText("Taxiing area is – 128 250,00");
                tv90.setText("Parking, road, service area is – 628 421,00");
                tv91.setText("Priming coat area is – 3 270 000,00");
                tv92.setText("Area for parking stands and base is – 154 721,00");
                tv106.setText("There are 2 runways at the airport:\n\nthe first runway is 4400 m x 60 m\n the second one is 4500 m x 60 m.");
                tv107.setText("the second runway was constructed in 2008; it has lighting equipment complying to ICAO Category III B. The runway 05L/23R is the longest one in the Central Asia, and it is included in the Top 20 longest runways in the world.\n" + "In 1998, Almaty airport installed new ABB lighting equipment for aircraft taking-off and landing which enabled aircraft to land, taxi and take-off as per QMS-232 ICAO Category II B Weather Minima, and QMS-52 ICAO Category I Weather Minima.\n" + "In December 2011, a group of experts from the Interstate Aviation Committee presented a Certificate of Category III B.\n");
                break;
        }
    }
}
