package com.example.dsm2016.memo.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.Window;

import com.example.dsm2016.memo.R;
import com.larswerkman.holocolorpicker.ColorPicker;

import static android.content.Intent.getIntent;

/**
 * Created by dsm2016 on 2018-03-14.
 */

public class Color_Dialog extends Dialog {
    ColorPicker colorPicker;
    Intent intent;
    public Color_Dialog(@NonNull Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);   //다이얼로그의 타이틀바를 없애주는 옵션입니다.
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.activity_color_dialog);
        intent=getIntent();
        int OldColor=intent.getIntExtra("OldColor",0);


    }
}
