package com.example.dsm2016.memo;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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

//        createDB();

        Log.d("1","1");
    }



    @Override
    public  void onCreate(SQLiteDatabase db) {
        Log.d("2","2");
        StringBuffer sb=new StringBuffer();
        sb.append(" CREATE TABLE MEMO ( ");
        sb.append(" _id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(" title TEXT, ");
        sb.append(" content TEXT ) ");
        db.execSQL(sb.toString());
       // db.execSQL("CREATE TABLE MEMO(_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT);");
        Log.d("DBHelper", "테이블 생성");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("3","3");

    }

    public void insert(MemoData memoData) {
        Log.d("4","4");
        SQLiteDatabase db = this.getWritableDatabase();
        StringBuffer sb=new StringBuffer();
        sb.append("insert into MEMO(");
        sb.append("title,content)");
        sb.append("values(?,?);");
       db.execSQL(sb.toString(), new Object[]{
            memoData.getTitle(),
                memoData.getContent()});
        Log.d("Insert","완료");
        // db.execSQL("INSERT INTO MEMO (_id, title, content) VALUES(null, '" + title + "','" + content + "');");
       // db.close();
    }

    public void update(String title, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE MEMO SET title=" + title + "," + "content=" + content + "WHERE title='" + title + "';");
        db.close();
        Log.d("5","5");
    }

    public void delete(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM MEMO WHERE title='" + title + "';");
        db.close();
        Log.d("6","6");
    }
   public void select(){
       StringBuffer sb=new StringBuffer();
       sb.append("select title from MEMO ");
       SQLiteDatabase db=this.getReadableDatabase();
       Cursor cursor=db.rawQuery(sb.toString(),null);
       MemoData memoData=new MemoData();

       if(cursor.moveToNext()){
          String title=cursor.getString(0);
          memoData.setTitle(title);

       }
        cursor.close();
       Log.d("7","7");
      /* String result="";
       Cursor cursor=db.rawQuery("SELECT TITLE FORM MEMO;",null);
       while (cursor.moveToNext()){
           result +=cursor.getString(0);
       }*/



   }
   public  void testDB(){
       Log.d("8","8");
       SQLiteDatabase db=getReadableDatabase();
       Log.d("dddd","dddd");
   }



}
