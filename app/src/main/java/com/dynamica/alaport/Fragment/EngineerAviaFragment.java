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
public class EngineerAviaFragment extends Fragment {
    TextView tv120,tv88,tv1,tv2,tv4,tv5,tv6,tv7,tv3,tv122;

    public EngineerAviaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_engineer_avia, container, false);
        tv120=(TextView) view.findViewById(R.id.textView120);tv120.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv122=(TextView) view.findViewById(R.id.textView122);tv122.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv88=(TextView) view.findViewById(R.id.textView88);tv88.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv1=(TextView) view.findViewById(R.id.textView1);tv1.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv2=(TextView) view.findViewById(R.id.textView2);tv2.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv4=(TextView) view.findViewById(R.id.textView4);tv4.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv5=(TextView) view.findViewById(R.id.textView5);tv5.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv6=(TextView) view.findViewById(R.id.textView6);tv6.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv7=(TextView) view.findViewById(R.id.textView7);tv7.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv3=(TextView) view.findViewById(R.id.textView3);tv3.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        setLang(((AlaportInfoActivity)getActivity()).lang);
        return view;
    }
    public void setLang(String s){
        switch (s){
            case "E":
                tv120.setText("Key functions of the Aviation Engineering Service:");
                tv88.setText("marshalling");
                tv1.setText("aircraft maintenance as per transit form");
                tv2.setText("provision of special equipment for aircraft handling");
                tv4.setText("deicing");
                tv5.setText("aircraft exterior and interior cleaning");
                tv6.setText("aircraft toilet cleaning");
                tv7.setText("nitrogen, oxygen, and compressed air services for aircraft");
                tv3.setText("pouring of landing gears");
                tv122.setText("Facilities and areas for maintenance of aviation equipments\n" + "In 2010, the airport invested over 100 million tenge for establishment of subdivision ALATECHNICS based on the Aviation Engineering Service for line maintenance of western-manufactured aircraft. It allowed reducing the number of aircraft delays due to technical reasons. Currently, the subdivision carries out line maintenance of FedEx’s MD-11 with the help of the airport. Audit of the ALATECHNICS according to the European standards gives opportunity to have an admission for line maintenance of the European cargo airlines such as CARGOLUX, CARGOITALIA, etc.");
                break;
            case "K":
                tv120.setText("ИАҚ негізгі қызметтері:");
                tv88.setText("әуе кемелерін күтіп алу / шығарып салуды қамтамасыз ету");
                tv1.setText("ӘК транзиттік нысан бойынша техникалық қызмет көрсету");
                tv2.setText("ӘК қызмет көрсету үшін арнайы техникамен қамтамасыз ету");
                tv4.setText("Диайсинг");
                tv5.setText("ӘК сыртын тазалау және ішкі тазалық жұмыстарын орындау");
                tv6.setText("ӘК дәретханаларын тазалау және оларды химиялық сұйықтықпен қамтамасыз ету");
                tv7.setText("ӘК азот, оттегі және сығылған ауамен қамтамасыз ету");
                tv3.setText("ӘК дөңгелектерін сұйықтықпен өңдеу");
                tv122.setText("Авиациялық техникаға техникалық қызмет көрсетуге арналған өндірістік құрылыстар мен алаңдар " + "2010 жылы әуежай ИАҚ базасында батыста өндірілген ұшақтарға желілік қызмет көрсететін «АЛАТЕХНИКС» бөлімшесін құру үшін 100 млн.теңдеден астам қаражат жұмсады. Осы бөлімшенің арқасында ӘК техникалық жағдайларға байланысты кешігулері қысқарды. Қазіргі таңда ФЭДЭКС авиакомпаниясының МД-11 ӘК желілік қызмет көрсету жұмыстары орындалуда. «АЛАТЕХНИКС» бөлімшесіне еуропа стандарты бойынша жүргізген аудит арқылы «КАРГОЛЮКС», «КАРГОИТАЛИЯ» сияқты еуропа жүк тасымалдау компанияларына желілік қызмет көрсетуге жол ашылуда");
                break;
        }
    }

}
