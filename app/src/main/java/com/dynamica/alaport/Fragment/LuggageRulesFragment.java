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
public class LuggageRulesFragment extends Fragment {
    ArrayList<TextView> tvs=new ArrayList<>();
    TextView tv131;
    int[] a={
            R.id.textView132,
            R.id.textView135,
            R.id.textView137,
            R.id.textView139,
            R.id.textView12,
            R.id.textView32
    };
    public LuggageRulesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_luggage_rules, container, false);
        tv131=(TextView) view.findViewById(R.id.textView131);
        tv131.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Heavy.ttf"));
        tvs=new ArrayList<>();
        for (int i=0;i<6;i++){
            tvs.add((TextView) view.findViewById(a[i]));
            tvs.get(i).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        }
        setLang(((HealthyInfoActivity)getActivity()).lang);
        return view;
    }
    void setLang(String s){
        switch (s){
            case "E":
                tv131.setText(getResources().getString(R.string.luggageruleeng));
                String[] q=("Ticket is an individual contractual document used to verify passenger carriage contract and its terms and conditions.\n" +
                        "Passenger is admitted for carriage if he/she has a valid ticket properly executed and issued by Carrier or its authorized agent. Passenger is not admitted for carriage if his/her ticket contains corrections and changes made by any third party other than Carrier or its authorized agent.\n" +
                        "Ticket is valid for carriage of passenger and his/her baggage from departure point to destination point subject to route and service class indicated in it. Each flight coupon or control coupon is valid for carriage of passenger and his/her baggage only subject to an itinerary route, service class, date and flight for which a seat is booked. If a ticket is issued without booking entry (with an open departure date), the booking shall be made according to request of a passenger subject to availability of free seats on a flight. Place and date of ticket sale must be entered in all its flight coupons.\n" +
                        "Ticket issued with an open departure date is valid for carriage of passenger and his/her baggage within one year from a departure date, and if no flight coupon is used, then within one year after a passenger ticket is issued, and it gives the right for flight only after a departure date and a flight number are entered in it by Carrier or its authorized representative.\n" +
                        "Ticket issued under a special fare is valid for carriage of passenger and his/her baggage only during a period fixed by application rules of such fare.\n" +
                        "Ticket validity shall be extended to a next flight of Carrier having a free seat of the same service class which corresponds to an initially paid fare, if a passenger could not take a flight during validity of the ticket in the following cases:" +
                        "1) flight indicated in a ticket is cancelled or delayed;" +
                        "1) aircraft does not land in an airport indicated in a ticket;").split("\n");
                for(int i=0;i<6;i++){
                    tvs.get(i).setText(q[i]);
                }
                break;
            case "K":
                tv131.setText(getResources().getString(R.string.luggagerulekz));
                String[] qq=("Билет жолаушыны әуеде тасымалдау келісімі мен шарттары жасалғанын растайтын, атаулы шартты құжат болып табылады.\n" +
                        "Жолаушы Тасымалдаушы немесе оның агенті тиісті дәрежеде толтырып берген жарамды билеті болғанда ғана тасымалдауға жіберіледі. Жолаушы, егер ол көрсеткен билетте Тасымалдаушы немесе оның агентінен басқа адамдар енгізген түзетулер немесе өзгерістер болса тасымалдауға жіберілмейді.\n" +
                        "Билет онда көрсетілген қызмет бағыты мен класы бойынша, жолаушы мен оның багажын жіберу пунктінен жету пунктіне дейін тасымалдау үшін жарамды болып табылады. Әрбір ұшу купоны немесе тексеру талоны жолаушы мен оның багажын брондалған орынға, онда көрсетілген бағыт участогы, қызмет көрсету класы, күні мен рейсі бойынша ғана жарамды.\n" +
                        "Егер билет брондау белгісінсіз (ұшудың ашық қалдырған күнімен) берілсе,онда орын жолаушы тілегіне сәйкес, сұрау салынған рейсте бос орындарының болуына қарай брондалады.\n" +
                        "Билет сатылған жері мен күні оның барлық купондарында көрсетілуі тиіс.\n" +
                        "Қалыпты тариф бойынша ашық ұшу күнімен тасымалдауға берілген билет, жолаушылар мен оның багажын тасымалдау үшін, тасымал басталған күннен бастап жарамды, ал егер бірде бір ұшу купоны пайдаланылмаса, онда билет берілген күннен бастап және онда Тасымалдаушы немесе оның өкілі рейстің ұшу күні мен нөмірін қойғаннан кейін ұшуға хақысы бар.\n" +
                        "Арнайы тариф бойынша тасымалдауға берілген билет осы тарифты қолдану ережелері белгіленген мерзімде ғана жолаушы оның багажын тасымалдауға жарамды.\n" +
                        "Билеттің жарамдылық мерзімі, егер жолаушы мына жағдайларда билет жарамдылығы мерзімі ішінде ұша алмай қалса, бастапқыда төленген тарифке сәйкес келетін сол қызмет көрсету класы бойынша бос орын бар, Тасымалдаушының ең жақын рейсіне дейін ұзартылады:" +
                        "1) билетте көрсетілген рейсті кейінге қалдыру немесе кешігу;" +
                        "2) билетте көрсетілген әуежайда әуе кемесі қона алмаса;").split("\n");
                for(int i=0;i<6;i++){
                    tvs.get(i).setText(qq[i]);
                }
                break;
        }
    }
}
