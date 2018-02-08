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
public class MedicalFragment extends Fragment {
    TextView tv142,tv145,tv146;

    public MedicalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_medical, container, false);
        tv142=(TextView) view.findViewById(R.id.textView142);
        tv142.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Heavy.ttf"));
        tv145=(TextView) view.findViewById(R.id.textView145);
        tv145.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv146=(TextView) view.findViewById(R.id.textView146);
        tv146.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        switch (((HealthyInfoActivity)getActivity()).lang){
            case "E":
                tv142.setText("Almaty International Airport JSC has First Aid Post which works for 24 hours."
                       );
                tv145.setText( "The staff includes:\n 5 physicians, 5 medical assistants. 5 physicians on duty for Mother & Child Room, and 4 drivers of ambulance car.\n"+"The equipment includes:\n 6 wheelchairs which of 4 narrow wheelchairs for delivery to a seat aboard an aircraft, and 2 ambulance cars (Mercedes-Benz, Hyundai 2013)\n" +
                        "All services are free of charge.\n" +
                        "Telephone: +7 (727) 270 30 30, +7 (727) 270 34 90\n" +
                        "E-ail: medoffice@alaport.com");
                tv146.setText("Sagdat Nurimanov Head of First Aid Post Almaty International Airport JSC\n" +
                        "Cell: +7 777 610 00 88");
                break;
            case "K":
                tv142.setText("Алматы қаласының әуежайында тәулік бойы жұмыс істейтін медициналық қызметі бар.");
                tv145.setText("Ол жерде:\n 5 дәрігер, 5 фельдшер, ана мен балаға арналған 5 кезекші бөлме және жедел жәрдем көрсету машинасының 4 жүргізушісі жұмыс жасайды.\n" +
                        "Жабдықталуы:\n 6 мүгедектер креслосы, оның ішінде ені тар, әуе кемесінің орындығына дейін жеткізуге арналған 4 кресло, 2 жедел жәрдем машинасы (Мерседес-Бенс , Хундай 2013 жылы шығарылған).\n" +
                        "Барлық қызметтер тегін көрсетіледі.\n" +
                        "Телефон: +7 (727) 270 30 30, +7 (727) 270 34 90\n" +
                        "Электрондық адрес: medoffice@alaport.com");
                tv146.setText("Алматы әуежайы Медициналық қызметінің бастығы Нұриманов Сағдат,\n" +
                        "ұялы телефон: +7 777 610 00 88");
                break;
        }
        return view;
    }

}
