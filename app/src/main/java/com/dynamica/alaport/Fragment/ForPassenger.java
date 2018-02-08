package com.dynamica.alaport.Fragment;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dynamica.alaport.HealthyInfoActivity;
import com.dynamica.alaport.R;
import com.dynamica.alaport.WebActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForPassenger extends Fragment {
    TextView tv123,tv124,tv126,tv127;
    public ForPassenger() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_for_passenger, container, false);
        ((RelativeLayout)view.findViewById(R.id.safety)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartInt("http://www.knb.kz");
            }
        });
        ((RelativeLayout)view.findViewById(R.id.finance)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartInt("http://www.minfin.gov.kz/irj/portal/anonymous");
            }
        });
        tv123=(TextView) view.findViewById(R.id.textView123);
        tv123.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv124=(TextView) view.findViewById(R.id.textView124);
        tv124.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv126=(TextView) view.findViewById(R.id.textView126);
        tv126.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv127=(TextView) view.findViewById(R.id.textView127);
        tv127.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        setLang(((HealthyInfoActivity)getActivity()).lang);
        return view;
    }
    public void setLang(String s){
        switch (s){
            case "K":
                tv123.setText("Қазақстан Республикасының шекарасынан шығу, жылжымалы әрі жылжымайтын мүлікті қайта ресімдеу және басқа қаржылық операциялық кезінде кедергілерді болдырмау үшін Қазақстан Республикасының Әділет министрлігі жеке және заңды тұлғаларға  www.adilet.gov.kz  сайтында сот актілері бойынша берешегін тексеруді ұсынады.");
                tv124.setText("Жүкті іздестіру телефондары: +7 (727) 270 31 04, +7 (727) 270 30 93");
                tv126.setText("Қазақстан Руспебликасы Ұлттық Қауіпсіздік Комитеті");
                tv127.setText("Қазақстан Республикасының қаржы министрлігі");
                break;
            case "E":
                tv123.setText("For the avoidance of any doubt when crossing the border of the Republic of Kazakhstan, re-registering the movable and immovable property, and other financial operations, the Ministry of Justice of the Republic of Kazakhstan recommends that individuals and legal entities should check for any existing debt which they may have under the judicial acts at the website: www.adilet.gov.kz");
                tv124.setText("Search of lost luggage tel: +7 (727) 270 31 04, +7 (727) 270 30 93");
                tv126.setText("The Committee of National Security of the Republic of Kazakhstan");
                tv127.setText("The Ministry of Finance of the Republic of Kazakhstan");
                break;
        }
    }
    public void StartInt(String url){
        Intent intent=new Intent(getActivity(), WebActivity.class);
        intent.putExtra("url",url);
        startActivity(intent);
    }
}
