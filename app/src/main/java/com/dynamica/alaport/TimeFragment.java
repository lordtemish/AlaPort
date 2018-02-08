package com.dynamica.alaport;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dynamica.alaport.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimeFragment extends Fragment {
    public String time;

    TextView  cancel, reset, set;
    FrameLayout up,down;
    TextView timeText;
    public TimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume(){
        super.onResume();
        setTime();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_time, container, false);
        RelativeLayout dialog=(RelativeLayout) view.findViewById(R.id.reldialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TopFragment)getParentFragment()).topClear();
                setTime();
            }
        });
        time=((TopFragment)getParentFragment()).time;
        timeText=(TextView) view.findViewById(R.id.textView22);
        timeText.setText(((TopFragment)getParentFragment()).time);
        up=(FrameLayout) view.findViewById(R.id.imageView15);
        down=(FrameLayout) view.findViewById(R.id.imageView16);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime(1);
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime(-1);
            }
        });
        timeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime(+1);
            }
        });
        cancel=(TextView) view.findViewById(R.id.button4);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TopFragment)getParentFragment()).topTimeChoose();
                setTime();
            }
        });
        reset=(TextView) view.findViewById(R.id.button3);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TopFragment)getParentFragment()).topTimeChoose();
                time="";
                timeText.setText("--:--");
                ((TopFragment)getParentFragment()).setTime("");
            }
        });
        set=(TextView) view.findViewById(R.id.button5);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TopFragment)getParentFragment()).topTimeChoose();

                ((TopFragment)getParentFragment()).setTime((timeText.getText()+"").substring(0,2));
            }
        });
        if(time.equals("")){
            timeText.setText("--:--");
        }
        else{
            timeText.setText(time+":00");
        }
        switch (((MainActivity)getActivity()).lang){
            case "E":
                set.setText("SET");
                reset.setText("RESET");
                cancel.setText("CANCEL");
                break;
            case "K":
                set.setText("ҚОЮ");
                reset.setText("АНЫҚ");
                cancel.setText("ЖОЮ");
                break;
            default:
                set.setText("ПОСТАВИТЬ");
                reset.setText("СБРОСИТЬ");
                cancel.setText("ОТМЕНА");
                break;
        }
        return view;
    }
    public void setTime(){
        time=((TopFragment)getParentFragment()).time;
        if(time.equals("")){
            timeText.setText("--:--");
        }
        else{
            timeText.setText(time+":00");
        }
    }
    public void setTime(int l){
        int summ=0;
        if(time.equals("")){
            summ=0;
        }
        else{
            summ=Integer.parseInt(time);
        }
        summ+=l;
        if(summ==-1){
            summ=23;
        }
        if(summ==24){
            summ=0;
        }
        if(summ<=9){
            time="0"+summ;
        }
        else{
            time=""+summ;
        }
        if(summ==0 || summ==24){
            timeText.setText("00:00");
        }
        else{
            timeText.setText(time+":00");
        }
    }
}
