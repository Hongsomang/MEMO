package com.example.dsm2016.memo;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import static android.R.attr.name;

/**
 * Created by dsm2016 on 2017-07-26.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    private Context context;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MEMO(_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT);");
        Log.d("DBHelper", "테이블 생성");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == DATABASE_VERSION) {
            db.execSQL("drop table MEMO");
            onCreate(db);
            Log.d("DBHelper", "버전 업");
        }
    }

    public void insert(String title, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO MEMO (_id, title, content) VALUES(null, '" + title + "','" + content + "');");
        db.close();
    }

    public void update(String title, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE MEMO SET title=" + title + "," + "content=" + content + "WHERE title='" + title + "';");
        db.close();
    }

    public void delete(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM MEMO WHERE title='" + title + "';");
        db.close();
    }

}
