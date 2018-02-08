package com.dynamica.alaport;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dynamica.alaport.Fragment.CityTransport;
import com.dynamica.alaport.Fragment.GarsonRulesFragment;
import com.dynamica.alaport.Fragment.LuggageLimitFragment;
import com.dynamica.alaport.Fragment.LuggageRulesFragment;
import com.dynamica.alaport.Fragment.MedicalFragment;
import com.dynamica.alaport.Fragment.ServicePassengerFragment;
import com.dynamica.alaport.Fragment.TransitPassengerFragment;
import com.dynamica.alaport.Fragment.ForPassenger;
import com.dynamica.alaport.Fragment.PassengerInstructionFragment;
import com.dynamica.alaport.R;

import java.util.ArrayList;

public class HealthyInfoActivity extends AppCompatActivity {
    int s;
    ArrayList<String> g;
    Fragment fr;
    public String lang;
    FrameLayout b;
    TextView title;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_info);
g=new ArrayList<>();
        SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = AlaportDataHelper.getReadableDatabase();
        Cursor cursor = db.query("user", new String[]{"LANGUAGE"}, "_id = ?", new String[] {Integer.toString(1)},null,null,null);
        if(cursor.moveToFirst()){
            String lan=cursor.getString(0);
            lang=lan;
        }
        cursor.close();
        db.close();

        title=(TextView) findViewById(R.id.raspNamr);
        title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/AvenirNext-Medium.ttf"));
        s=getIntent().getIntExtra("number",0);
        b=(FrameLayout) findViewById(R.id.backDr1);
        Button b1=(Button) findViewById(R.id.backDr);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backPressed();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backPressed();
            }
        });
        fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        fr=new Fragment();
        setLang(lang);
        switch (s){
            case 0:
                title.setText(g.get(0));
                fr=new ForPassenger();
                break;
            case 1:
                title.setText(g.get(1));
                fr=new TransitPassengerFragment();
                break;
            case 2:
                title.setText(g.get(2));
                fr=new ServicePassengerFragment();
                break;
            case 3:
                title.setText(g.get(3));
                fr=new LuggageRulesFragment();
                break;
            case 4:
                title.setText(g.get(4));
                fr=new LuggageLimitFragment();
                break;
            case 5:
                title.setText(g.get(5));
                fr=new CityTransport();
                break;
            case 6:
                title.setText(g.get(6));
                fr=new PassengerInstructionFragment();
                break;
            case 7:
                title.setText(g.get(7));
                fr=new MedicalFragment();
                break;
            case 8:
                title.setText(g.get(8));
                fr=new GarsonRulesFragment();
                break;
        }
        ft.replace(R.id.frameal,fr);
        ft.commit();
    }
    public void setLang(String s){
        switch (s){
            case "K":
                g.add("ЖОЛАУШЫЛАРҒА");
                g.add("ТРАНЗИТТІ ЖОЛАУШЫЛАР ТУРАЛЫ АҚПАРАТ");
                g.add("ЖОЛАУШЫЛАР ТЕРМИНАЛЫНДАҒЫ СЕРВИС");
                g.add("ТАСЫМАЛДАУ ЕРЕЖЕСІ");
                g.add("ТАСЫМАЛДАУҒА ШЕКТЕУ");
                g.add("ӘУЕЖАЙҒА ЖҮРЕТІН ҚАЛАЛЫҚ КӨЛІК БАҒЫТТАРЫ:");
                g.add("АВИАЖОЛАУШЫЛАРҒА АРНАЛҒАН НҰСҚАУЛЫҚ");
                g.add("МЕДИЦИНАЛЫҚ ҚЫЗМЕТТЕРІ");
                g.add("ҰЙЫМДАСТЫРУ ҚАҒИДАСЫ");
                break;
            case "E":
                g.add("FOR PASSENGER");
                g.add("INFORMATION ON TRANSIT PASSENGERS");
                g.add("SERVICE IN PASSENGER TERMINAL");
                g.add("RULES FOR AIR CARRIAGE");
                g.add("CARRIAGE RESTRICTIONS");
                g.add("URBAN TRAFFIC ROUTE TO THE AIRPORT");
                g.add("INSTRUCTIONS FOR AIR PASSENGERS");
                g.add("MEDICAL SERVICE");
                g.add("RULES FOR PASSENGER SERVICE");
                break;
            default:
                g.add("Пассажиру");
                g.add("Инф. о транзитных пассажирах");
                g.add("Сервис в пас. терминале");
                g.add("Правила перевозок");
                g.add("Ограничения перевозок");
                g.add("Маршруты гор. транспорта");
                g.add("Инструкция для авиапассажиров");
                g.add("Услуги мед. службы");
                g.add("Правила обслуживания");
                break;
        }
    }
    @Override
    public void onBackPressed(){
        if(s==5){
                CityTransport frag=(CityTransport) fr;
                if(frag.rel.getChildAt(0)==frag.resultmap){
                    frag.backset();
                }
                else{
                    super.onBackPressed();
                }

        }
        else {
            super.onBackPressed();
        }
    }
    public void backPressed(){
        super.onBackPressed();
    }
}
