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
public class PassangerTransportFragment extends Fragment {
    TextView tv105,tv88,tv89,tv90,tv91,tv92,tv93,tv94,tv104,tv11,tv12,tv13,tv14,tv15,tv16;
    public PassangerTransportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_passanger_transport, container, false);
        tv105=(TextView) view.findViewById(R.id.textView105);tv105.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv104=(TextView) view.findViewById(R.id.textView104);tv104.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv88=(TextView) view.findViewById(R.id.textView88);tv88.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv89=(TextView) view.findViewById(R.id.textView89);tv89.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv90=(TextView) view.findViewById(R.id.textView90);tv90.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv91=(TextView) view.findViewById(R.id.textView91);tv91.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv92=(TextView) view.findViewById(R.id.textView92);tv92.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv93=(TextView) view.findViewById(R.id.textView93);tv93.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv94=(TextView) view.findViewById(R.id.textView94);tv94.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv11=(TextView) view.findViewById(R.id.textView11);tv11.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv12=(TextView) view.findViewById(R.id.textView12);tv12.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv13=(TextView) view.findViewById(R.id.textView13);tv13.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv14=(TextView) view.findViewById(R.id.textView14);tv14.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv15=(TextView) view.findViewById(R.id.textView15);tv15.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv16=(TextView) view.findViewById(R.id.textView16);tv16.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        setLang(((AlaportInfoActivity)getActivity()).lang);
        return view;
    }
    public void setLang(String s){
        switch (s){
            case "E":
                tv105.setText("The Passenger Handling Department provides the following services:");
                tv88.setText("Arrivals and departures displays");
                tv89.setText("Passenger check-in for international flights");
                tv90.setText("Passenger check-in for domestic flights");
                tv91.setText("Duty Free shop, French House, Souvenirs, etc");
                tv92.setText("Baggage trolleys");
                tv93.setText("Lost and Found");
                tv94.setText("Booking offices");
                tv104.setText("Existing buildings in the Almaty airport territory:");
                tv11.setText("VIP Southern building " + "Total area is 695 sq.m.");
                tv12.setText("The building is destined for meeting and accompanying the official delegations");
                tv13.setText("Business terminal (with gallery). " + "Usable area is 2761,6 sq.m. The building is destined for departure of VIP passengers.");
                tv14.setText("Former international arrivals building. " + "Usable area is 2956,2 sq.m.");
                tv15.setText("The building is used for office premises of Almaty International Airport JSC.");
                tv16.setText("Passenger terminal " + "Total area is 28 963 sq.m. " + "The building is destined for passenger and baggage handling for international and domestic flights.");
                break;
            case "K":
                tv105.setText("Жолаушылар тасымалдауларын ұйымдастыру қызметі келесі қызмет түрлерін ұсынады:");
                tv88.setText("Ұшып кету/ұшып келу туралы ақпараттық табло");
                tv89.setText("Жолаушыларды халықаралық авиарейстерге тіркеу");
                tv90.setText("Жолаушыларды ішкі авиарейстерге тіркеу");
                tv91.setText("Duty Free, Французский дом, Кәдесый дүкендері");
                tv92.setText("Багаж және қол жүгін тасымалдауға арналған арбалар");
                tv93.setText("Жоғалған жүкті іздестіру");
                tv94.setText("Авиатасымалдауларды сату кассалары");
                tv104.setText("Алматы әуежайының аумағында орналасқан ғимараттар");
                tv11.setText("VIP Оңтүстік ғимараты. " +
                        "Үй-жайлардың жалпы көлемі 695 ш. м.");
                tv12.setText("Ғимарат ресми делегацияларды күтіп алу, шығарып салуға арналған.");
                tv13.setText("Бизнес-терминал ғимараты( галереясымен) . " + "Пайдалы алаң 2761,6 ш. м. " + "ғимарат ВИП категорияда ұшатын жолаушыларға арналған.");
                tv14.setText("Ескі халықаралық ұшып келу ғимараты. " + "Пайдалы алаң 956,2 ш. м.");
                tv15.setText("Ғимаратта «ХАӘ»АҚ қызметтік үй-жайлары орналасқан.");
                tv16.setText("Жолаушылар терминалының ғимараты " + "жалпы алаңы 28 963 ш. м.");
                break;
        }
    }
}
