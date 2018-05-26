package com.example.dsm2016.memo.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;

import com.example.dsm2016.memo.R;
import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.OpacityBar;
import com.larswerkman.holocolorpicker.SVBar;
import com.larswerkman.holocolorpicker.SaturationBar;
import com.larswerkman.holocolorpicker.ValueBar;

import static android.app.Activity.RESULT_OK;
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
       // intent=getIntent();
        int OldColor=intent.getIntExtra("OldColor",0);
        colorPicker=(ColorPicker)findViewById(R.id.picker);
        SVBar svBar=(SVBar)findViewById(R.id.svbar);
        OpacityBar opacityBar=(OpacityBar)findViewById(R.id.opacitybar);
        SaturationBar saturationBar=(SaturationBar)findViewById(R.id.saturationbar);
        ValueBar valueBar=(ValueBar)findViewById(R.id.valuebar);
        colorPicker.addSVBar(svBar);
        colorPicker.addOpacityBar(opacityBar);
        colorPicker.addSaturationBar(saturationBar);
        colorPicker.addValueBar(valueBar);   

        colorPicker.getColor();

        if(OldColor !=0){
            colorPicker.setOldCenterColor(OldColor);

        }else {
            colorPicker.setOldCenterColor(colorPicker.getColor());
        }

    }
    public  void getColor(View view){
        intent.putExtra("color",colorPicker.getColor());
        //setResult(RESULT_OK,intent);
       // finish();
    }
}
