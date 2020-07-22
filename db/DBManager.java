package com.example.user.gifticonmanagement.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 2020-07-21.
 */

public class DBManager extends SQLiteOpenHelper {
    //맴버변수
    private static final String DATABASE_NAME = "giftDB.db";
    private static final int DATABASE_VERSION = 1;

    //생성자
    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //테이블 생성
        db.execSQL("create table items(name TEXT, img_src TEXT, db_year INT, db_month INT, db_day INT);");
    }//end onCreate()

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists items");
        onCreate(db);
    }//end onUpgrade()
}
