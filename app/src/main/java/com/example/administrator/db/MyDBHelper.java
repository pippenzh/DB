package com.example.administrator.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2015/7/28.
 */
public class MyDBHelper extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_USER = "create table " + ManageContract.UserEntry.TABLE_NAME + "(" +
            ManageContract.UserEntry._ID + " INTEGER PRIMARY KEY," +
            ManageContract.UserEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
            ManageContract.UserEntry.COLUMN_NAME_PHONE + TEXT_TYPE +
            ")";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ManageContract.UserEntry.TABLE_NAME;

    public MyDBHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
