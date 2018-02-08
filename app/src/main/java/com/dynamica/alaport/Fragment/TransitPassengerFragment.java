package com.dynamica.alaport.Fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dynamica.alaport.HealthyInfoActivity;
import com.dynamica.alaport.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransitPassengerFragment extends Fragment {
    TextView tv128,tv129;

    public TransitPassengerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_transit_passenger, container, false);
        tv128=(TextView) view.findViewById(R.id.textView128);
        tv128.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Black.ttf"));
        tv129=(TextView) view.findViewById(R.id.textView129);
        tv129.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        setLang(((HealthyInfoActivity)getActivity()).lang);
        return view;
    }
    void  setLang(String s){
        switch (s){
            case "K":
                tv128.setText("Қазақстан Республикасының шекарасынан шығу, жылжымалы әрі жылжымайтын мүлікті қайта ресімдеу және басқа қаржылық операциялық кезінде кедергілерді болдырмау үшін Қазақстан Республикасының Әділет министрлігі жеке және заңды тұлғаларға  www.adilet.gov.kz  сайтында сот актілері бойынша берешегін тексеруді ұсынады.");
                tv129.setText("Жүкті іздестіру телефондары: +7 (727) 270 31 04, +7 (727) 270 30 93.");
                break;
            case "E":
                tv128.setText("Dear citizens and guests of the Southern Capital, we would like to inform you that on April 27, 2011, Almaty International Airport changed procedures for handling of transit and transfer passengers. A new scheme of movement is convenient for passengers and it meets international standards of passenger service.");
                tv129.setText("1. Transit and transfer passengers together with other passengers are transported from distant parking stands to the international arrival lounge by bus, and then they should follow the arrows to the transit lounge. Boarding for the next flight is performed in the international departure lounge on the second floor.\n" + "2. Transit and transfer passengers together with other passengers arrived using the air bridges should go down the stairs or the elevator to the international arrival lounge, and then they should follow the arrows to the transit lounge. Boarding for the next flight is performed in the international departure lounge on the second floor.\n");
                break;
        }
    }
}
