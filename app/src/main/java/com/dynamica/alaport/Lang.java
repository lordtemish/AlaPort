package com.dynamica.alaport;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.dynamica.alaport.R;

public class Lang extends AppCompatActivity {
    CheckBox cv;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(this);
        db = AlaportDataHelper.getReadableDatabase();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang);
        cv=(CheckBox) findViewById(R.id.checkBox);
        ((TextView) findViewById(R.id.textView8)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Lang.this,SoglActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    public void update(String s){
        ContentValues cv=new ContentValues();
        cv.put("LANGUAGE",s);
        db.update("user",cv,"_id=?",new String[] {Integer.toString(1)});
    }
    @Override
    public void onBackPressed() {
        Log.d("Back","Pressed");
    }
    public void KazL(View view){
        update("K");
    }
    public void RusL(View view){
        update("R");
    }
    public void EngL(View view){
        update("E");
    }
    public void destroyThis(View view){
        if(cv.isChecked()){
        finish();
        db.close();
        }
        else{
            Log.d("Log","Pressed");
        }
    }
}
