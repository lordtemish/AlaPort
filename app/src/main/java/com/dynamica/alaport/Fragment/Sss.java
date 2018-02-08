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
public class Sss extends Fragment {
    TextView autoP,text;

    public Sss() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_sss, container, false);
        autoP=(TextView) view.findViewById(R.id.textView92);
        autoP.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Heavy.ttf"));
        text=(TextView) view.findViewById(R.id.textView101);
        text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        setLang(((AlaportInfoActivity)getActivity()).lang);
        return view;
    }
    public void setLang(String s){
        switch(s){
            case "E":
                autoP.setText("Car parking");
                text.setText("The Service Department manages the following areas:\n" + "Car parking\n" + "The territory in front of the passenger terminal is intended for 261 parking lots.\n" + "The multi-storey car park, including the fenced territory adjacent to the car parking, is intended for 328 cars.\n" + "The automated park management system Modpark, consisting of 4 entrance units and 7 exit units, 6 automated cashier terminals, software, video identification and recognition of vehicle registration number subsystems (VISPA), and video surveillance Designa-Asytec.");
                break;
            case "K":
                autoP.setText("Автотұрақ");
                text.setText("СКҚ қарамағында:\n" + "Автотұрақ\n" + "Вокзал маңындағы аумақ 261 тұрақ орнына есептелген;\n" + "Жабық автотұрақ – 328 автокөлік, оның ішінде автотұрақ қасындағы қоршалған аумақ;\n" + "«Modpark» автоматтандырылған тұрақ жүйесі 4 кіру 7 шығу топтарымен, 6 автоматтандырылған касса терминалдарымен, бағдарламалық жасау, автокөліктердің мемлекеттік нөмірлерін бейнесәйкестендіру жүйесі(VISPA) және «Designa-Asytec» шолу бейнебақылау жүйесімен жабдықталған.");
                break;
        }
    }
}
