package com.example.administrator.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MainActivity extends ActionBarActivity {
    private ListView mListView;
    private SimpleCursorAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.lv_user);

        MyDBHelper myDBHelper = new MyDBHelper(this, "manage", 4);
//        SQLiteDatabase dbWriter = myDBHelper.getWritableDatabase();
//        ContentValues cv  = new ContentValues();
//        cv.put("name", "zhangsan");
//        cv.put("phone", "12345");
//        dbWriter.insert("user", null, cv);
//
//        cv  = new ContentValues();
//        cv.put("name", "lisi");
//        cv.put("phone", "7890");
//        dbWriter.insert("user", null, cv);
//
//        dbWriter.close();

        SQLiteDatabase dbReader = myDBHelper.getReadableDatabase();
        //Cursor c = dbReader.query("user", null, "name=? and phone=?", new String[]{"lisi", "7890"}, null, null, null);
        Cursor c = dbReader.query("user", null, null, null, null, null, null );

        mAdapter = new SimpleCursorAdapter(this, R.layout.list_item, c, new String[]{"name"}, new int[] {R.id.tv_name});
        mListView.setAdapter(mAdapter);
        while (c.moveToNext()) {
            String name = c.getString(c.getColumnIndex("name"));
            String phone = c.getString(c.getColumnIndex("phone"));
            Log.d("lsx", "name: " + name + "| phone: " + phone);
        }

        if (c != null) c.close();
        if (dbReader != null) dbReader.close();

    }

}
