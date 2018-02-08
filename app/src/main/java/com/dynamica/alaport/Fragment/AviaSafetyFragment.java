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
public class AviaSafetyFragment extends Fragment {
    TextView tv108,tv109,tv110,tv111,tv112,tv113,tv114,tv115,tv116,tv117,tv118,tv119;

    public AviaSafetyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_avia_safety, container, false);
        tv108=(TextView) view.findViewById(R.id.textView108);tv108.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv109=(TextView) view.findViewById(R.id.textView109);tv109.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv110=(TextView) view.findViewById(R.id.textView110);tv110.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv111=(TextView) view.findViewById(R.id.textView111);tv111.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv112=(TextView) view.findViewById(R.id.textView112);tv112.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv113=(TextView) view.findViewById(R.id.textView113);tv113.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv114=(TextView) view.findViewById(R.id.textView114);tv114.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv115=(TextView) view.findViewById(R.id.textView115);tv115.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv116=(TextView) view.findViewById(R.id.textView116);tv116.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv117=(TextView) view.findViewById(R.id.textView117);tv117.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv118=(TextView) view.findViewById(R.id.textView118);tv118.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv119=(TextView) view.findViewById(R.id.textView119);tv119.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        setLang(((AlaportInfoActivity)getActivity()).lang);
        return view;
    }
    public void setLang(String s){
        switch (s){
            case "E":
                tv108.setText("Equipment of the Security Check Service.");
                tv109.setText("Introscopes");
                tv110.setText("42 units");
                tv111.setText("Stationary metal detectors");
                tv112.setText("31 units");
                tv113.setText("Hand-held metal detectors");
                tv114.setText("51 units");
                tv115.setText("Scanner SECURE-100");
                tv116.setText("2 units");
                tv117.setText("HEDT-1000");
                tv118.setText("10 units");
                tv119.setText("The main purpose of Aviation Security Service’s activity is to ensure aviation security and prevent acts of unlawful interference in activity of Almaty International Airport JSC.\n" + "Inspection of passengers, crew members, hand baggage, baggage, cargo, mail, and personnel is a package of measures using the technical means and other ones intended for detection of weapons, explosives, and other dangerous devices and items prohibited for carriage which can be used for acts of unlawful interference.");
                break;
            case "K":
                tv108.setText("Тексеру қызметінің техникалық жабдықталуы.");
                tv109.setText("Интроскоптар");
                tv110.setText("42 дана");
                tv111.setText("Стационарлық темір іздегіштер");
                tv112.setText("31 дана");
                tv113.setText("Қол темір іздегіштер ");
                tv114.setText("51 дана");
                tv115.setText("Scanner SECURE-100 ");
                tv116.setText("2 дана");
                tv117.setText("HEDT-1000");
                tv118.setText("10 дана");
                tv119.setText("АҚҚ басты мақсаты - «Халықаралық Алматы әуежайы»АҚ қызметіне заңсыз қол сұғу әрекеттерін болдырмау және авиациялық қауіпсіздікті қамтамасыз ету\n" + "Жолаушылар мен ӘК экипажын тексеру, қол жүгі, багаж, жүк, пошта және қызмет көрсету персоналын тексеру (ары қарай-тексеру) жұмыстары- заңсыз қол сұғу әрекеттеріне пайдаланатын қару, жарылғыш заттар, басқа да тасымалдауға тыйым салынған қауіпті заттарды айқындауға арналған техникалық және басқа құралдарды пайдалана отырып жүргізілетін шаралар кешені.");
                break;
        }
    }
}
