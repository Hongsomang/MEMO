package com.example.dsm2016.memo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dsm2016.memo.R;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

/**
 * Created by dsm2016 on 2018-03-08.
 */

public class SplashActivity extends AppCompatActivity {
    Shimmer shimmer;
    ShimmerTextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv=(ShimmerTextView)findViewById(R.id.shimmer_tv);
        shimmer=new Shimmer();
        shimmer.start(tv);
        Handler hd=new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                //startActivity(new Intent(this,MainActivity.class));
                finish();
            }
        },4000);


    }
}
