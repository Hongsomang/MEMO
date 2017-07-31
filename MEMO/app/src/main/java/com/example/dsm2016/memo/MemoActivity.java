package com.example.dsm2016.memo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * Created by dsm2016 on 2017-07-26.
 */

public class MemoActivity extends AppCompatActivity implements View.OnClickListener {
    private DBHelper dbHelper;
    // EditText titlefiled,memofiled;
    ImageButton savebtn, backbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo_activity);
        // titlefiled=(EditText)findViewById(R.id.titlefiled);
        // memofiled=(EditText)findViewById(R.id.memofiled);
        savebtn = (ImageButton) findViewById(R.id.save);
        backbtn = (ImageButton) findViewById(R.id.back);
        savebtn.setOnClickListener(saveClick);
        Log.d("9","9");
    }

    View.OnClickListener saveClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dbHelper = new DBHelper(getApplicationContext(), "Memo.db", null);
            dbHelper.testDB();
            Log.d("fff","fff");
            final EditText titlefiled = (EditText) findViewById(R.id.titlefiled);
            final EditText memofiled = (EditText) findViewById(R.id.memofiled);
            if (titlefiled.getText().toString().length() == 0) {
                Toast.makeText(MemoActivity.this, "제목을 입력해 주세요", Toast.LENGTH_LONG).show();
                titlefiled.requestFocus();
                return;
            } else if (memofiled.getText().toString().length() == 0) {
                Toast.makeText(MemoActivity.this, "내용을 입력해주세요", Toast.LENGTH_LONG).show();
                memofiled.requestFocus();
                return;
            } else if (titlefiled.getText().toString().length() == 0 && memofiled.getText().toString().length() == 0) {
                Toast.makeText(MemoActivity.this, "제목과 내용을 입력해주세요", Toast.LENGTH_LONG).show();
                titlefiled.requestFocus();
                return;
            }
            //db저장
            String title = titlefiled.getText().toString();
            String memo = memofiled.getText().toString();
            MemoData memoData=new MemoData();
            memoData.setTitle(title);
            memoData.setContent(memo);
            dbHelper.insert(memoData);
            //dbHelper.insert(title, memo);
            //dbHelper.insert("insert into MEMO values(null,'"+title+"',"+memo+");");
            Log.d("데이터", "저장");
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(getApplication(), "저장되었습니다.", Toast.LENGTH_LONG).show();
        }


    };

    @Override
    public void onClick(View v) {

    }
}
