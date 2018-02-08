package com.dynamica.alaport.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dynamica.alaport.MainActivity;
import com.dynamica.alaport.R;


public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public String succesfull;
    public String goback;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        TextView tv157=(TextView) view.findViewById(R.id.textView157);
        TextView tv156=(TextView) view.findViewById(R.id.textView156);
        setLang(((MainActivity)getActivity()).lang);
        tv157.setText(succesfull);
        tv156.setText(goback);
        LinearLayout ll=(LinearLayout) view.findViewById(R.id.backLayout);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return view;
    }
    private void setLang(String s){
        switch (s){
            case "E":
                succesfull="Successfully sent";
                goback="Go back";
                break;
            case "K":
                goback="Артқа";
                succesfull="Жіберген";
                break;
            default:
                goback="Назад";
                succesfull="Успешно отправлено";
                break;
        }
    }
}
