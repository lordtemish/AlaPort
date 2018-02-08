package com.dynamica.alaport;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 17-n008ur on 16.08.2017.
 */

public class AlaportDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "alaportdb"; // the name of our database
    private static final int DB_VERSION = 1;
    public AlaportDatabaseHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE user (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT NULL, LANGUAGE TEXT, NOTIFA TEXT NULL);");
        db.execSQL("CREATE TABLE notification (_id INTEGER PRIMARY KEY AUTOINCREMENT,ID TEXT, CITY TEXT , TIME TEXT, DATE TEXT, BEFORE INTEGER NULL, TIMEMILL TEXT, DEPS TEXT);");
        ContentValues cv=new ContentValues();
        cv.put("NAME","");
        cv.put("LANGUAGE","R");
        cv.put("NOTIFA","T");
        db.insert("user","",cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV,int newV){

    }
}
