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


/**
 * A simple {@link Fragment} subclass.
 */
public class LongChooseDialog extends Fragment {
    TextView butt, but1;
    RelativeLayout rldep,rlarr, dialog;
    ImageView iv12,iv13;
    public LongChooseDialog() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_long_choose_dialog, container, false);
        dialog=(RelativeLayout) view.findViewById(R.id.reldialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RaspFragment)getParentFragment()).removeChoose();
            }
        });
        butt=(TextView) view.findViewById(R.id.butt);
        iv12=(ImageView) view.findViewById(R.id.imageView12);
        iv13=(ImageView) view.findViewById(R.id.imageView13);
        but1=(TextView) view.findViewById(R.id.but1);
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
        rldep=(RelativeLayout) view.findViewById(R.id.longrec1);
        rlarr=(RelativeLayout) view.findViewById(R.id.longrec2);
        rldep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RaspFragment)getParentFragment()).setArrs();
                setColor(0);
            }
        });
        rlarr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RaspFragment)getParentFragment()).setDeps();
                setColor(1);
            }
        });
        setColor(0);
        return view;
    }
    public void setColor(int a){
        switch (a){
            case 0:
                rldep.setBackground(getResources().getDrawable(R.drawable.whiteutton));
                rlarr.setBackground(getResources().getDrawable(R.drawable.mybutton));
                butt.setTextColor(getResources().getColor(R.color.black));
                but1.setTextColor(getResources().getColor(R.color.white));
                iv13.setImageResource(R.drawable.planarrival);
                iv12.setImageResource(R.drawable.plandepblue);
                break;
            case 1:
                rldep.setBackground(getResources().getDrawable(R.drawable.mybutton));
                rlarr.setBackground(getResources().getDrawable(R.drawable.whiteutton));
                but1.setTextColor(getResources().getColor(R.color.black));
                butt.setTextColor(getResources().getColor(R.color.white));
                iv13.setImageResource(R.drawable.planarrivalblue);
                iv12.setImageResource(R.drawable.plandeps);
                break;
        }
    }
}
