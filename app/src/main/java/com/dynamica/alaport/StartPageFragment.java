package com.dynamica.alaport;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dynamica.alaport.R;

import java.util.ArrayList;
import java.util.Random;



public class StartPageFragment extends Fragment {




    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    int pageNumber;
    View view;
    int backColor;
   static ArrayList<Button> buts=new ArrayList<>();
    static StartPageFragment newInstance(int page1) {
        StartPageFragment pageFragment = new StartPageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page1);
        Log.d("Crate page",page1+"");
        pageFragment.setArguments(arguments);
        return pageFragment;
    }
    public void MakeButton(int j){
        for(int i=0;i<4;i++){
            if(i==j){
                buts.get(i).setBackground(getResources().getDrawable(R.drawable.whitec));
            }
            else{
                buts.get(i).setBackground(getResources().getDrawable(R.drawable.cir));
            }
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

        Random rnd = new Random();
        backColor = Color.argb(40, 0,62 ,168 );
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_start_page, null);
        ImageView tvPage = (ImageView) view.findViewById(R.id.pageimg);
        tvPage.setBackground(getResources().getDrawable(R.drawable.firstfirst));
        setData(getArguments().getInt(ARGUMENT_PAGE_NUMBER));
        return view;
    }
    public void setData(int position){
        ImageView img=(ImageView) view.findViewById(R.id.pageimg);
        TextView t1=(TextView) view.findViewById(R.id.textView);
        TextView t2=(TextView) view.findViewById(R.id.textView2);
        Animation FadeAnim= AnimationUtils.loadAnimation(view.getContext(),R.anim.fadein);
        //img.startAnimation(FadeAnim);
        int page=0;
        if(position==0){
            t1.setText("");
            t2.setText("");
        }
        else if(position==1){

            img.setBackground(getResources().getDrawable(R.drawable.firstqwee));
            t1.setText("АКТУАЛЬНОЕ");
            t2.setText("РАСПИСАНИЕ \nВСЕХ РЕЙСОВ");
        }
        else if(position==2){

            img.setBackground(getResources().getDrawable(R.drawable.third));
            t1.setText("НАПОМИНАНИЕ");
            t2.setText("ИНТЕРЕСНОГО \nВАМ РЕЙСА");
        }
        else{

            img.setBackground(getResources().getDrawable(R.drawable.fourth));
            t1.setText("ПОЛЕЗНАЯ");
            t2.setText("ИНФОРМАЦИЯ \nПЕРЕД ВЫЛЕТОМ");
        }

    }

}
