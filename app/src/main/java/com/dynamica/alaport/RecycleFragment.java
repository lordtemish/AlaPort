package com.dynamica.alaport;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dynamica.alaport.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecycleFragment extends Fragment {
    RecyclerView lv;
    String lang;
    TopAdapter mAdap;
    public RecycleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        lang=((MainActivity)getActivity()).lang;
        Bundle bundle=this.getArguments();
        View view=inflater.inflate(R.layout.fragment_recycle,container,false);
        Parser parser=new Parser();
        ArrayList<Arrival> arrs=parser.ArrParsing(bundle.getString("arrival"));
        Log.d("Length",arrs.size()+"");
        int l=0;
        for(Arrival i:arrs){
            Log.d("Arrivals"+(l++),i.getInfo());
        }

        List<String> qwe=new ArrayList<>();
        for(Arrival i:arrs) {
            qwe.add(i.aln.get(0));
        }
        lv=(RecyclerView) view.findViewById(R.id.topView);
        mAdap=new TopAdapter(arrs,lang,false, getActivity());

        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity());
        lv.setLayoutManager(mLayoutManager);
        lv.setItemAnimator(new DefaultItemAnimator());
        lv.setAdapter(mAdap);
        lv.addItemDecoration(new DividerItemDecoration(lv.getContext(),
                DividerItemDecoration.HORIZONTAL));
        return view;
    }

}
