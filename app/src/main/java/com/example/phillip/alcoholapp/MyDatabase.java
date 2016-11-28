package com.example.phillip.alcoholapp;
import android.content.Context;

import  com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Phillip on 6/5/2016.
 */
public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "Alcohol.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}