package com.dynamica.alaport;



import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dynamica.alaport.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParkingFragment extends Fragment {
    TextView tarifT,timeT,priceT,t2,p2, t4,p4,t6,p6,t12,p12,t24,p24,tm,pm, text, warn, freeName, freePrice;

    public ParkingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_parking, container, false);
        text=(TextView) view.findViewById(R.id.textView100);
        warn=(TextView) view.findViewById(R.id.textView99);
        freeName=(TextView) view.findViewById(R.id.textView122);
        freeName.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        freePrice=(TextView) view.findViewById(R.id.textView123);
        freePrice.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tarifT=(TextView) view.findViewById(R.id.textView89);
        tarifT.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Heavy.ttf"));
        timeT=(TextView) view.findViewById(R.id.textView90);
        timeT.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        priceT=(TextView) view.findViewById(R.id.textView91);
        priceT.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        t2=(TextView) view.findViewById(R.id.textView93);p2=(TextView) view.findViewById(R.id.textView103);t2.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        t4=(TextView) view.findViewById(R.id.textView94);p4=(TextView) view.findViewById(R.id.textView104);t4.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        t6=(TextView) view.findViewById(R.id.textView98);p6=(TextView) view.findViewById(R.id.textView108);t6.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        t12=(TextView) view.findViewById(R.id.textView97);p12=(TextView) view.findViewById(R.id.textView107);t12.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        t24=(TextView) view.findViewById(R.id.textView96);p24=(TextView) view.findViewById(R.id.textView106);t24.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tm=(TextView) view.findViewById(R.id.textView95);pm=(TextView) view.findViewById(R.id.textView105);tm.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        setLang(((AlaportInfoActivity)getActivity()).lang);
        return view;
    }
    public void setLang(String s){
        switch (s){
            case "E":
                tarifT.setText("RATES");
                timeT.setText("Time (hours)");
                priceT.setText("Cost (KZT)");
                freeName.setText("Till 15 minutes");
                freePrice.setText("Free");
                t2.setText("From 15 minutes to 2 hours");p2.setText("300");
                t4.setText("Up to 4 hours");p4.setText("500");
                t6.setText("Up to 6 hours");p6.setText("800");
                t12.setText("From 15 minutes to 2 hours");p12.setText("1200");
                t24.setText("From 15 minutes to 2 hours");p24.setText("1800");
                tm.setText("From 15 minutes to 2 hours");pm.setText("2000");
                warn.setText("Make attention");
                text.setText("Payment should be made using the cashier terminals of the Parking only. Payment is not accepted on the exit. ");
                break;
            case "K":
                tarifT.setText("ТАРИФТЕР");
                timeT.setText("Уақыт мерзімі (сағатпен)");
                priceT.setText("Құны (теңге)");
                freeName.setText("15 минутқа дейін");
                freePrice.setText("Тегін");
                t2.setText("15 минуттан 2 сағатқа дейін");p2.setText("300");
                t4.setText("4 сағатқа дейін");
                p4.setText("500");
                t6.setText("6 сағатқа дейін");p6.setText("800");
                t12.setText("12 сағатқа дейін");p12.setText("1200");
                t24.setText("24 сағатқа дейінs");p24.setText("1800");
                tm.setText("24 сағаттан астам және одан арғы толық және жартылай тәулікке");pm.setText("2000");
                warn.setText("Назар аударыңыз");
                text.setText("Төлемдер тек тұрақтың кассалық терминалдарында жасалады. Шығудағы төлеу қабылдамайды.");
                break;
        }
    }
}
