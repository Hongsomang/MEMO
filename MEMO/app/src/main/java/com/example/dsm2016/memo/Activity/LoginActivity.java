package com.example.dsm2016.memo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.RecoverySystem;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.processbutton.iml.ActionProcessButton;
import com.example.dsm2016.memo.Interface.ProgressGenerator;
import com.example.dsm2016.memo.R;

/**
 * Created by dsm2016 on 2018-03-08.
 */

public class LoginActivity extends AppCompatActivity implements ProgressGenerator.OnCompleteListener {
     EditText eamil_et,pwd_et;
    ProgressGenerator progressGenerator;
    ActionProcessButton btnSignIn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eamil_et=(EditText)findViewById(R.id.login_email_et);
        pwd_et=(EditText)findViewById(R.id.login_pwd_et);

        progressGenerator=new ProgressGenerator(this);
        btnSignIn=(ActionProcessButton)findViewById(R.id. btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressGenerator.start(btnSignIn);
                btnSignIn.setEnabled(false);
                eamil_et.setEnabled(false);
                pwd_et.setEnabled(false);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void oncomplete() {
        Toast.makeText(this, "로그인 완료", Toast.LENGTH_LONG).show();

    }
}
