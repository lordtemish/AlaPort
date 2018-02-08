package com.dynamica.alaport;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dynamica.alaport.R;


public class DialogTopFragment extends Fragment{
    TextView butt,but1;
    RelativeLayout rel1,rel2, dialog;
    ImageView iv12,iv13;
    public DialogTopFragment(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                       Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_dialog_top,null,false);
        butt=(TextView) view.findViewById(R.id.butt);
        but1=(TextView) view.findViewById(R.id.but1);
        iv12=(ImageView) view.findViewById(R.id.imageView12);
        iv13=(ImageView) view.findViewById(R.id.imageView13);

        switch (((MainActivity)getActivity()).lang){
            case "E":
                butt.setText("Arrivals");
                but1.setText("Departures");
                break;
            case "K":
                butt.setText("Ұшып келу");
                but1.setText("Ұшып кету");
                break;
            default:
                butt.setText("Прилеты");
                but1.setText("Вылеты");
                break;
        }
        dialog=(RelativeLayout) view.findViewById(R.id.reldialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TopFragment)getParentFragment()).topClear();
            }
        });
        rel1=(RelativeLayout) view.findViewById(R.id.arrs);
        rel2=(RelativeLayout) view.findViewById(R.id.deps);
        rel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TopFragment)getParentFragment()).topArrChoose();
                ((TopFragment)getParentFragment()).setArrivals();
                setV(0);
            }
        });
        rel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TopFragment)getParentFragment()).topArrChoose();
                ((TopFragment)getParentFragment()).setDepartures();
                setV(1);
            }
        });
        setV(0);
        return view;
    }
    public void setV(int i){
        switch (i){
            case 0:
                rel1.setBackground(getResources().getDrawable(R.drawable.whiteutton));
                rel2.setBackground(getResources().getDrawable(R.drawable.mybutton));
                butt.setTextColor(getResources().getColor(R.color.black));
                but1.setTextColor(getResources().getColor(R.color.white));
                iv12.setImageResource(R.drawable.plandepblue);
                iv13.setImageResource(R.drawable.planarrival);
                break;
            case 1:
                rel2.setBackground(getResources().getDrawable(R.drawable.whiteutton));
                rel1.setBackground(getResources().getDrawable(R.drawable.mybutton));
                but1.setTextColor(getResources().getColor(R.color.black));
                butt.setTextColor(getResources().getColor(R.color.white));
                iv12.setImageResource(R.drawable.plandeps);
                iv13.setImageResource(R.drawable.planarrivalblue);
                break;
        }
    }
}
