package com.dynamica.alaport;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dynamica.alaport.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HealthyFragment extends Fragment {
    RecyclerView rv;
    ArrayList<String> g;
    TextView table;
    public HealthyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_healthy, container, false);
        table=(TextView) view.findViewById(R.id.TableName);
        rv=(RecyclerView) view.findViewById(R.id.healthyRec);
        g=new ArrayList<>();
        setLang(((MainActivity)getActivity()).lang);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(new HealthyAdapter(g, getActivity()));
        return view;
    }
    public void setLang(String s) {
        switch (s) {
            case "K":
                table.setText("Қызметтік бағдарлама");
                g.add("Ж"+"ОЛАУШЫЛАР".toLowerCase());
                g.add("Т"+"РАНЗИТТІ ЖОЛАУШЫЛАР ТУРАЛЫ АҚПАРАТ".toLowerCase());
                g.add("Ж"+"ОЛАУШЫЛАР ТЕРМИНАЛЫНДАҒЫ СЕРВИС".toLowerCase());
                g.add("Т"+"АСЫМАЛДАУ ЕРЕЖЕСІ".toLowerCase());
                g.add("Т"+"АСЫМАЛДАУҒА ШЕКТЕУ".toLowerCase());
                g.add("Ә"+"УЕЖАЙҒА ЖҮРЕТІН ҚАЛАЛЫҚ КӨЛІК БАҒЫТТАРЫ:".toLowerCase());
                g.add("А"+"ВИАЖОЛАУШЫЛАРҒА АРНАЛҒАН НҰСҚАУЛЫҚ".toLowerCase());
                g.add("М"+"ЕДИЦИНАЛЫҚ ҚЫЗМЕТТЕРІ".toLowerCase());
                g.add("Ұ"+"ЙЫМДАСТЫРУ ҚАҒИДАСЫ".toLowerCase());
                break;
            case "E":
                table.setText("Utilities");
                g.add("P"+"ASSENGER".toLowerCase());
                g.add("I"+"NFORMATION ON TRANSIT PASSENGERS".toLowerCase());
                g.add("S"+"ERVICE IN PASSENGER TERMINAL".toLowerCase());
                g.add("R"+"ULES FOR AIR CARRIAGE".toLowerCase());
                g.add("C"+"ARRIAGE RESTRICTIONS".toLowerCase());
                g.add("U"+"RBAN TRAFFIC ROUTE TO THE AIRPORT".toLowerCase());
                g.add("I"+"NSTRUCTIONS FOR AIR PASSENGERS".toLowerCase());
                g.add("Medical service");
                g.add("R"+"ULES FOR PASSENGER SERVICE".toLowerCase());
                break;
            default:
                g.add("Пассажиру");
                g.add("Инф. о транзитных пассажирах");
                g.add("Сервис в пас. терминале");
                g.add("Правила перевозок");
                g.add("Ограничения перевозок");
                g.add("Маршруты гор. транспорта");
                g.add("Инструкция для авиапассажиров");
                g.add("Услуги мед. службы");
                g.add("Правила обслуживания");
                break;
        }
    }

}
