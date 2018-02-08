package com.dynamica.alaport;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dynamica.alaport.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_chooseday extends Fragment {
    public RelativeLayout rs;
    public TextView rst;
    public TextView rsdate;
    public RelativeLayout rs1, dialog;
    public TextView rst1;
    public TextView rsdate1;
    public RelativeLayout rs2;
    public TextView rst2;
    public TextView rsdate2;

    public fragment_chooseday() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        //sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        cal.add(Calendar.DATE,-1);
        android.text.format.Time time=new android.text.format.Time(Time.getCurrentTimezone());
        View view=inflater.inflate(R.layout.fragment_fragment_chooseday, container, false);
        dialog=(RelativeLayout) view.findViewById(R.id.reldialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TopFragment)getParentFragment()).topClear();
            }
        });

        rs=(RelativeLayout) view.findViewById(R.id.arrs);
        rst=(TextView) view.findViewById(R.id.butt1);
        rsdate=(TextView) view.findViewById(R.id.textView19);
        rs1=(RelativeLayout) view.findViewById(R.id.arrs1);
        rst1=(TextView) view.findViewById(R.id.butt);
        rsdate1=(TextView) view.findViewById(R.id.textView21);
        rs2=(RelativeLayout) view.findViewById(R.id.arrs2);
        rst2=(TextView) view.findViewById(R.id.butt3);
        rsdate2=(TextView) view.findViewById(R.id.textView20);

        time.setToNow();
        String yesterday="";

        rsdate.setText(sdf.format(cal.getTime()));
        cal=Calendar.getInstance();
        Log.d("Cal",sdf.format(cal.getTime())+"");
        rsdate2.setText(sdf.format(cal.getTime()));
        cal=Calendar.getInstance();
        cal.add(Calendar.DATE,+1);
        rsdate1.setText(sdf.format(cal.getTime()));
        switch (((MainActivity)getActivity()).lang){
            case "E":
                rst.setText("Yesterday");
                rst1.setText("Tomorrow");
                rst2.setText("Today");
                break;
            case "K":
                rst.setText("Кеше");
                rst1.setText("Ертең");
                rst2.setText("Бүгін");
                break;
            default:
                rst.setText("Вчера");
                rst1.setText("Завтра");
                rst2.setText("Сегодня");
                break;
        }
    setD(0);


        rs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TopFragment)getParentFragment()).setToday();
                setD(0);
            }
        });
        rs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TopFragment)getParentFragment()).setTomorow();
                setD(1);
            }
        });
        rs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TopFragment)getParentFragment()).setYesterday();
                setD(2);
            }
        });
        return view;
    }
    public void setD(int a){
        switch (a){
            case 0:
                rs2.setBackground(getResources().getDrawable(R.drawable.whiteutton));
                rs1.setBackground(getResources().getDrawable(R.drawable.mybutton));
                rs.setBackground(getResources().getDrawable(R.drawable.mybutton));
                rsdate2.setTextColor(getResources().getColor(R.color.black));
                rsdate1.setTextColor(getResources().getColor(R.color.white));
                rsdate.setTextColor(getResources().getColor(R.color.white));
                rst2.setTextColor(getResources().getColor(R.color.black));
                rst1.setTextColor(getResources().getColor(R.color.white));
                rst.setTextColor(getResources().getColor(R.color.white));
                break;
            case 1:
                rs2.setBackground(getResources().getDrawable(R.drawable.mybutton));
                rs1.setBackground(getResources().getDrawable(R.drawable.whiteutton));
                rs.setBackground(getResources().getDrawable(R.drawable.mybutton));
                rsdate2.setTextColor(getResources().getColor(R.color.white));
                rsdate1.setTextColor(getResources().getColor(R.color.black));
                rsdate.setTextColor(getResources().getColor(R.color.white));
                rst2.setTextColor(getResources().getColor(R.color.white));
                rst1.setTextColor(getResources().getColor(R.color.black));
                rst.setTextColor(getResources().getColor(R.color.white));
                break;
            case 2:
                rs2.setBackground(getResources().getDrawable(R.drawable.mybutton));
                rs1.setBackground(getResources().getDrawable(R.drawable.mybutton));
                rs.setBackground(getResources().getDrawable(R.drawable.whiteutton));
                rsdate2.setTextColor(getResources().getColor(R.color.white));
                rsdate1.setTextColor(getResources().getColor(R.color.white));
                rsdate.setTextColor(getResources().getColor(R.color.black));
                rst2.setTextColor(getResources().getColor(R.color.white));
                rst1.setTextColor(getResources().getColor(R.color.white));
                rst.setTextColor(getResources().getColor(R.color.black));
                break;
        }
    }

}
