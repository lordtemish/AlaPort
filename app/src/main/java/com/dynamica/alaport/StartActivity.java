package com.dynamica.alaport;
import com.dynamica.alaport.R;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

public class StartActivity extends FragmentActivity {
    static final String TAG = "myLogs";
    static final int PAGE_COUNT = 4;
    private View myFragmentView;
    ArrayList<Button> buttons;
    FragmentManager fm;
    ViewPager pager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        buttons=new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
//        ((Button) StartPageFragment.view.findViewById(R.id.but0)).setBackground(getResources().getDrawable(R.drawable.box_green));

        pager = (ViewPager) findViewById(R.id.pager);

        pager.setOffscreenPageLimit(PAGE_COUNT);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        View vqw=pager.getRootView();
        View vie=pager.getChildAt(0);
        //Button fir=(Button) vie.findViewById(R.id.but0);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                /*View vie=pager.getChildAt(position);
              //  Log.d("view paggg",(vie==null)+"");
                ImageView img=(ImageView) vie.findViewById(R.id.pageimg);
                TextView t1=(TextView) vie.findViewById(R.id.textView);
                TextView t2=(TextView) vie.findViewById(R.id.textView2);
                Animation FadeAnim= AnimationUtils.loadAnimation(vie.getContext(),R.anim.fadein);
                //img.startAnimation(FadeAnim);
                int page=0;
                if(position==0){
                    page=R.id.but0;
                    t1.setText("");
                    t2.setText("");
                }
                else if(position==1){
                    page=R.id.but1;
                    img.setBackground(getResources().getDrawable(R.drawable.firstqwee));
                    t1.setText("АКТУАЛЬНОЕ");
                    t2.setText("РАСПИСАНИЕ \nВСЕХ РЕЙСОВ");
                }
                else if(position==2){
                    page=R.id.but2;
                    img.setBackground(getResources().getDrawable(R.drawable.third));
                    t1.setText("НАПОМИНАНИЕ");
                    t2.setText("ИНТЕРЕСНОГО \nВАМ РЕЙСА");
                }
                else{
                    page=R.id.but3;
                    img.setBackground(getResources().getDrawable(R.drawable.fourth));
                    t1.setText("ПОЛЕЗНАЯ");
                    t2.setText("ИНФОРМАЦИЯ \nПЕРЕД ВЫЛЕТОМ");
                }

                Button b=(Button) vie.findViewById(page);
                ((Button) vie.findViewById(R.id.but0)).setBackground(getResources().getDrawable(R.drawable.circle));
                b.setBackground(getResources().getDrawable(R.drawable.whitec));*/
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
                SetPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
    private int getItem(int i){
        return pager.getCurrentItem()+i;
    }
    public void SetPage(int position) {
        int page=0;
        switch (position){

            case 0:
                page=R.id.but0;
                break;
            case 1:
                page=R.id.but1;
                break;
            case 2:
                page=R.id.but2;
                break;
            case 3:
                page=R.id.but3;
                break;
        }
        ((Button)findViewById(R.id.but0)).setBackground(getResources().getDrawable(R.drawable.circle));
        ((Button)findViewById(R.id.but1)).setBackground(getResources().getDrawable(R.drawable.circle));
        ((Button)findViewById(R.id.but2)).setBackground(getResources().getDrawable(R.drawable.circle));
        ((Button)findViewById(R.id.but3)).setBackground(getResources().getDrawable(R.drawable.circle));
        Button b=(Button) findViewById(page);
        b.setBackground(getResources().getDrawable(R.drawable.whitec));
    }
    public void FirstPage(View view){
        Button but=(Button) view.findViewById(R.id.but0);
        if(pager.getCurrentItem()==0){
            pager.setCurrentItem(1,true);
        }
        else
        pager.setCurrentItem(0,true);

    }
    public void SecondPage(View view){
        if(pager.getCurrentItem()==1){
            pager.setCurrentItem(2,true);
        }
        else
        pager.setCurrentItem(1,true);
        //MakeButton(1);
    }
    public void ThirdPage(View view){
        if(pager.getCurrentItem()==2){
            pager.setCurrentItem(3,true);
        }
        else
        pager.setCurrentItem(2,true);
        //MakeButton(2);
    }
    public void FourthPage(View view){
        if(pager.getCurrentItem()==3){
            pager.setCurrentItem(2,true);
        }
        else
        pager.setCurrentItem(3,true);
       // MakeButton(3);
    }

    public void nextClick(View view){
        pager.setCurrentItem(getItem(+1),true);
    }
    public void butClick(View view){
        super.onBackPressed();
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        HashMap<Integer,Fragment> fragments=new HashMap<>();

        @Override
        public Fragment getItem(int position) {
            Fragment testfr=StartPageFragment.newInstance(position);
            return testfr;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
    @Override
    protected void onResume() {
        super.onResume();

    }
}