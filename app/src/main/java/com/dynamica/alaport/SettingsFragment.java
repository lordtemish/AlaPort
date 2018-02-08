package com.dynamica.alaport;



import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.dynamica.alaport.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {
    View view;
    Switch aSwitch;
    AppCompatRadioButton kz;
    AppCompatRadioButton rus;
    AppCompatRadioButton eng;SQLiteDatabase db;
    TextView rasdr,t14,t16;
    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_settings, container, false);
        rasdr=(TextView) view.findViewById(R.id.rasdr);
        t14=(TextView) view.findViewById(R.id.textView14);
        t16=(TextView) view.findViewById(R.id.textView16);
        kz=(AppCompatRadioButton) view.findViewById(R.id.kz);
        eng=(AppCompatRadioButton) view.findViewById(R.id.eng);
        rus=(AppCompatRadioButton) view.findViewById(R.id.rus);
        aSwitch=(Switch) view.findViewById(R.id.switch1);
        SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(view.getContext());
        db = AlaportDataHelper.getReadableDatabase();
        RadioGroup radioGroup=(RadioGroup) view.findViewById(R.id.radgroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(view.getContext());
                SQLiteDatabase db= AlaportDataHelper.getReadableDatabase();
                AppCompatRadioButton but=(AppCompatRadioButton) view.findViewById(radioGroup.getCheckedRadioButtonId());
                String s="";
                switch (but.getId()){
                    case R.id.kz:
                        s="K";
                        ((MainActivity)getActivity()).DrawerChange(s);
                        setLang(s);
                        break;
                    case R.id.rus:
                        s="R";
                        ((MainActivity)getActivity()).DrawerChange(s);
                        setLang(s);
                        break;
                    case R.id.eng:
                        s="E";
                        ((MainActivity)getActivity()).DrawerChange(s);
                        setLang(s);
                        break;
                }
                ContentValues cv=new ContentValues();
                cv.put("LANGUAGE",s);
                db.update("user",cv,"_id=?",new String[] {Integer.toString(1)});
            }
        });
        Cursor cursor = db.query("user", new String[]{"LANGUAGE","NOTIFA"}, "_id = ?", new String[] {Integer.toString(1)},null,null,null);
        String lan="R";
        if(cursor.moveToFirst()){
            lan=cursor.getString(0);
            if(cursor.getString(1).equals("T")){
                aSwitch.setChecked(true);
            }
        }
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(view.getContext());
                SQLiteDatabase db= AlaportDataHelper.getReadableDatabase();
                String s;
                if(isChecked){
                    s="T";
                }
                else{
                    s="F";
                }
                ContentValues cv=new ContentValues();
                cv.put("NOTIFA",s);
                db.update("user",cv,"_id=?",new String[] {Integer.toString(1)});
            }
        });

        switch (lan){
            case "R":
                rus.setChecked(true);
                break;
            case "K":
                kz.setChecked(true);
                break;
            case "E":
                eng.setChecked(true);
                break;
        }
        setLang(lan);

        return view;
    }
    void setColor(String s){
        switch (s){
            case "K":
                rus.setTextColor(getResources().getColor(R.color.colorPrimary11C));
                eng.setTextColor(getResources().getColor(R.color.colorPrimary11C));
                kz.setTextColor(getResources().getColor(R.color.whity));
                break;
            case "E":
                rus.setTextColor(getResources().getColor(R.color.colorPrimary11C));
                kz.setTextColor(getResources().getColor(R.color.colorPrimary11C));
                eng.setTextColor(getResources().getColor(R.color.whity));
                break;
            case "R":
                kz.setTextColor(getResources().getColor(R.color.colorPrimary11C));
                eng.setTextColor(getResources().getColor(R.color.colorPrimary11C));
                rus.setTextColor(getResources().getColor(R.color.whity));
                break;
}
    }
    public void setLang(String s){
        switch (s){
            case "K":
                rasdr.setText("Параметрлері");
                t14.setText("Push хабарламалар");
                t16.setText("Интерфейстің тілі");
                break;
            case "E":
                rasdr.setText("Settings");
                t14.setText("Push notifications");
                t16.setText("Inerface language");
                break;
            case "R":
                rasdr.setText("Настройки");
                t14.setText("Push уведомления");
                t16.setText("Язык интерфейса");
                break;
        }
        setColor(s);
    }
    @Override
    public void onPause(){
        super.onPause();
    }
    @Override public void onStop(){
        db.close();
        super.onStop();
    }
}
