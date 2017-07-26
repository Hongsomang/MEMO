package com.example.dsm2016.memo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by dsm2016 on 2017-07-26.
 */

public class MemoActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText titlefiled,memofiled;
    private ImageButton savebtn,backbtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo_activity);
        titlefiled=(EditText)findViewById(R.id.titlefiled);
        memofiled=(EditText)findViewById(R.id.memofiled);
        savebtn=(ImageButton)findViewById(R.id.save);
        backbtn=(ImageButton)findViewById(R.id.back);


    }

    @Override
    public void onClick(View v) {

    }
}
