package com.example.dsm2016.memo.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.dsm2016.memo.Dialog.Thichness_Dialog;
import com.example.dsm2016.memo.R;
import com.example.dsm2016.memo.iteam.Thichness_Item;

/**
 * Created by dsm2016 on 2018-03-12.
 */

public class DrawingAcitivity extends AppCompatActivity {
    Thichness_Dialog td;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics(); //디바이스 화면크기를 구하기위해
        int width = dm.widthPixels; //디바이스 화면 너비
        int height = dm.heightPixels; //디바이스 화면 높이
        td=new Thichness_Dialog(this);
        WindowManager.LayoutParams wm = td.getWindow().getAttributes();  //다이얼로그의 높이 너비 설정하기위해
        wm.copyFrom(td.getWindow().getAttributes());  //여기서 설정한값을 그대로 다이얼로그에 넣겠다는의미
        wm.width = width / 2;  //화면 너비의 절반
        wm.height = height / 3;  //화면 높이의 절반
        Button thickness=(Button)findViewById(R.id.thickness);
        thickness.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View view) {
                td.show();
           }
      });
        int a=Thichness_Item.getInstance().getThichness();
        Log.d("값", String.valueOf(a));
    }
}
