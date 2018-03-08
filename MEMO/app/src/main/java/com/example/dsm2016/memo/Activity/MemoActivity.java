package com.example.dsm2016.memo.Activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dsm2016.memo.R;

public class MemoActivity extends AppCompatActivity {
    ImageView back,save;
    EditText title,content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        back=(ImageView)findViewById(R.id.memo_back_bt);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("배고파","배고파");
                dialog();
            }
        });
        save=(ImageView)findViewById(R.id.memo_save_bt);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog();
            }
        });

    }

    void dialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("저장")
                .setMessage("저장하시겠습니까?")
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"저장되었습니다.",Toast.LENGTH_LONG).show();
                        finish();
                    }
                })
        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }
}
