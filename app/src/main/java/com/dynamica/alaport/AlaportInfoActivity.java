package com.dynamica.alaport;
import com.dynamica.alaport.Fragment.AirdromFragment;
import com.dynamica.alaport.Fragment.MultiModalFragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dynamica.alaport.Fragment.AviaSafetyFragment;
import com.dynamica.alaport.Fragment.EngineerAviaFragment;
import com.dynamica.alaport.Fragment.PassangerTransportFragment;
import com.dynamica.alaport.Fragment.Sss;
import com.dynamica.alaport.R;

import java.util.ArrayList;

public class AlaportInfoActivity extends AppCompatActivity {
    android.support.v4.app.FragmentManager fm;
    Fragment fragment;
    ArrayList<String> g;
    TextView rasp;
    public String lang;
    int numb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alaport_info);
        SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = AlaportDataHelper.getReadableDatabase();
        Cursor cursor = db.query("user", new String[]{"LANGUAGE"}, "_id = ?", new String[] {Integer.toString(1)},null,null,null);
        if(cursor.moveToFirst()){
            String lan=cursor.getString(0);
            lang=lan;
        }
        cursor.close();
        db.close();
        fm=getSupportFragmentManager();
        //fragment=fm.findFragmentById(R.id.fragment4);

        rasp=(TextView) findViewById(R.id.raspNamr);
        rasp.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/AvenirNext-Medium.ttf"));
        FrameLayout backdr=(FrameLayout) findViewById(R.id.backDr1);
        Button backdr1=(Button) findViewById(R.id.backDr);
        backdr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        backdr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        numb=getIntent().getIntExtra("number",0);
        FragmentTransaction ft=fm.beginTransaction();
        Fragment fr=new Fragment();
        g=new ArrayList<>();
        setLang();
        switch(numb){
            case 0:
                rasp.setText(g.get(0));
                fr=new HistoryFragment();
                break;
            case 1:
                rasp.setText(g.get(1));
                fr=new AirportAlaFragment();
                break;
            case 2:
                rasp.setText(g.get(2));
                fr=new AviaGazFragment();
                break;
            case 3:
                rasp.setText(g.get(3));
                fr=new Spasop();
                break;
            case 4:
                rasp.setText(g.get(4));
                fr=new ParkingFragment();
                break;
            case 5:
                rasp.setText(g.get(5));
                fr=new Sss();
                break;
            case 6:
                rasp.setText(g.get(6));
                fr=new AirdromFragment();
                break;
            case 7:
                rasp.setText(g.get(7));
                fr=new AviaSafetyFragment();
                break;
            case 8:
                rasp.setText(g.get(8));
                fr=new PassangerTransportFragment();
                break;
            case 9:
                rasp.setText(g.get(9));
                fr=new MultiModalFragment();
                break;
            case 10:
                rasp.setText(g.get(10));
                fr=new EngineerAviaFragment();
                break;
        }
        ft.replace(R.id.frameal,fr);
        ft.commit();
    }
    public void setLang(){
        switch (lang){
            case "E":
                g.add("HISTORY");g.add("AIRPORT");g.add("AVIATION FUEL"); g.add("SEARCH AND RESCUE SERVICE");g.add("PARKING");g.add("SERVICE DEPARTMENT");g.add("AERODROME SERVICE");g.add("AVIATION SECURITY SERVICE");
                g.add("PASSENGER HANDLING DEPARTMENT");g.add("MULTIMODAL TERMINAL");g.add("AVIATION ENGINEERING SERVICE");
                break;
            case "K":
                g.add("ТАРИХ");g.add("ӘУЕЖАЙ");g.add("АВИАОТЫН"); g.add("ӨҚЖҰАҚҚҚ");g.add("АВТОТҰРАҚ");g.add("СЕРВИС КӨРСЕТУ ҚЫЗМЕТІ");g.add("АЭРОАЛАҢ ҚЫЗМЕТІ");g.add("АВИАЦИЯЛЫҚ ҚАУІПСІЗДІК ҚЫЗМЕТІ");
                g.add("ЖОЛАУШЫЛАР ТАСЫМАЛДАУЛАРЫН ҰЙЫМДАСТЫРУ ҚЫЗМЕТІ");g.add("МУЛЬТИМОДАЛДЫ ТЕРМИНАЛ");g.add("ИНЖИНЕРЛІК-АВИАЦИЯЛЫҚ ҚЫЗМЕТ");
                break;
            default:
                g.add("История");g.add("Аэропорт");g.add("Авиа топливо"); g.add("СПАСОП");g.add("Парковка");g.add("Служба сервисных услуг");g.add("Аэродромная служба");g.add("Служба авиа безопасности");
                g.add("Орг. пассажирских перевозок");g.add("Мультимодальный терминал");g.add("Инженерно-авиационная служба");
                break;
        }
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
