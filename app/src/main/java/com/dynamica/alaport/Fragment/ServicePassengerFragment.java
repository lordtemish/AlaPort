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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServicePassengerFragment extends Fragment {
    TextView tv130;
    ArrayList<TextView> tvs;
    int[] a={
            R.id.textView7,
            R.id.textView8,
            R.id.textView9,
            R.id.textView10,
            R.id.textView11,
            R.id.textView12,
            R.id.textView13,
            R.id.textView14,
            R.id.textView15,
            R.id.textView16,
            R.id.textView17,
            R.id.textView18,
            R.id.textView19,
            R.id.textView20,
            R.id.textView21,
            R.id.textView22,
            R.id.textView23,
            R.id.textView24,
            R.id.textView25,
            R.id.textView26,
            R.id.textView27,
            R.id.textView28,
            R.id.textView29,
            R.id.textView30,
    };
    public ServicePassengerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tvs=new ArrayList<>();
       View view=inflater.inflate(R.layout.fragment_service_passenger, container, false);
        tv130=(TextView) view.findViewById(R.id.textView130);
        tv130.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Black.ttf"));
        for (int i=0;i<24;i++){
            tvs.add((TextView) view.findViewById(a[i]));
            tvs.get(i).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        }
        setLang(((HealthyInfoActivity)getActivity()).lang);
        return view;
    }
    void setLang(String s){
        switch (s){
            case "E":
                tv130.setText("The following services are rendered to passengers in the passenger terminal:");
                String[] q=("Information desk\n" +
                        "Arrivals and departures displays\n" +
                        "Passenger check-in for international flights\n" +
                        "Passenger check-in for domestic flights\n" +
                        "Consular Section\n" +
                        "Café, bars, and fast food\n" +
                        "Baggage Room\n" +
                        "Baggage trolleys\n" +
                        "Exchange office\n" +
                        "Mother-and-child room\n" +
                        "First Aid Post\n" +
                        "Lost and Found\n" +
                        "Prayer Room\n" +
                        "Baggage wrapping\n" +
                        "Booking offices\n" +
                        "Duty-free shop, French House, Souvenirs, etc.\n" +
                        "Payment for parking\n" +
                        "Newspaper and magazine kiosks\n" +
                        "Kazpost\n" +
                        "ATMs\n" +
                        "Pay telephones\n" +
                        "Internet\n" +
                        "Meeting point\n" +
                        "Wi-Fi").split("\n");
                for(int i=0;i<24;i++){
                    tvs.get(i).setText(q[i]);
                }
                break;
            case "K":
                tv130.setText("Жолаушылар терминалында авиажолаушыларға келесі қызметтер ұсынылады:");
                String[] qq=("Анықтама бюросы\n" +
                        "Ұшып келу/ ұшып кету ақпараттық таблосы\n" +
                        "Жолаушыларды халықаралық авиарейстерге тіркеу\n" +
                        "Жолаушыларды ішкі авиарейстерге тіркеу\n" +
                        "Консулдық бөлім\n" +
                        "Кафе, бар, Fast food\n" +
                        "Жүк сақтау камерасы\n" +
                        "Багаж және қол жүгін тасымалдайтын арбалар\n" +
                        "Валюта айырбастау\n" +
                        "Ана және бала бөлмесі\n" +
                        "Медпункт\n" +
                        "Жоғалған жүкті іздестіру\n" +
                        "Намазхана\n" +
                        "Жүкті буып-түю\n" +
                        "Авиатасымалдауларды сату кассалары\n" +
                        "Дьюти фри, Французский дом, Сувениры дүкендері\n" +
                        "Тұрақ ақысын төлеу\n" +
                        "Газет, журнал дүңгіршектері\n" +
                        "Қазпошта\n" +
                        "Банкоматтар\n" +
                        "Телефон-автоматтар\n" +
                        "Интернет\n" +
                        "Кездесу орны\n" +
                        "Wi-Fi").split("\n");
                for(int i=0;i<24;i++){
                    tvs.get(i).setText(qq[i]);
                }
                break;
        }
    }

}
