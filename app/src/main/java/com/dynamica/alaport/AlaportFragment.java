package com.dynamica.alaport;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dynamica.alaport.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlaportFragment extends Fragment {
    RecyclerView recV;

    public AlaportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_alaport, container, false);
        recV=(RecyclerView) view.findViewById(R.id.alapRec);
        ArrayList<String> g=new ArrayList<>();
        switch(((MainActivity)getActivity()).lang) {
            case "E":
                g.add("History");g.add("Airport");g.add("Fuelling"); g.add("S"+"EARCH AND RESCUE SERVICE".toLowerCase());g.add("Parking");g.add("Service department");g.add("Aerodrome service");g.add("Aviation Security service");
                g.add("Passenger handling department");g.add("Multimodal terminal");g.add("Aviation engineering service");
                break;
            case "K":
                g.add("Тарих");g.add("Әуежай");g.add("Авиаотын"); g.add("Өқжұақққ".toUpperCase());g.add("Автотұрақ");g.add("Сервис көрсету қызметі");g.add("А"+"ЭРОАЛАҢ ҚЫЗМЕТІ".toLowerCase());g.add("А"+"ВИАЦИЯЛЫҚ ҚАУІПСІЗДІК ҚЫЗМЕТІ".toLowerCase());
                g.add("Ж"+"ОЛАУШЫЛАР ТАСЫМАЛДАУЛАРЫН ҰЙЫМДАСТЫРУ ҚЫЗМЕТІ".toLowerCase());g.add("М"+"УЛЬТИМОДАЛДЫ ТЕРМИНАЛ".toLowerCase());g.add("И"+"НЖеНЕРЛІК-АВИАЦИЯЛЫҚ ҚЫЗМЕТ".toLowerCase());
                break;
            default:
                g.add("История");g.add("Аэропорт");g.add("Авиа топливо"); g.add("СПАСОП");g.add("Парковка");g.add("Служба сервисных услуг");g.add("Аэродромная служба");g.add("Служба авиа безопасности");
                g.add("Орг. пассажирских перевозок");g.add("Мультимодальный терминал");g.add("Инженерно-авиационная служба");
                break;
        }

        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity());
        recV.setLayoutManager(mLayoutManager);
        recV.setItemAnimator(new DefaultItemAnimator());
        recV.setAdapter(new AlaportAdapter(g,getActivity()));
        return view;
    }

}
