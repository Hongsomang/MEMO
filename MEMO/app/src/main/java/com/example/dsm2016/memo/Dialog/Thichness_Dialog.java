package com.example.dsm2016.memo.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.dsm2016.memo.R;
import com.example.dsm2016.memo.iteam.Thichness_Item;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

/**
 * Created by dsm2016 on 2018-03-12.
 */

public class Thichness_Dialog extends Dialog  {
    public Thichness_Dialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);   //다이얼로그의 타이틀바를 없애주는 옵션입니다.
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.activity_thichness_dialog);
        Button save=(Button)findViewById(R.id.thichness_save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiscreteSeekBar discreteSeekBar1 = (DiscreteSeekBar) findViewById(R.id.discrete1);
                discreteSeekBar1.setNumericTransformer(new DiscreteSeekBar.NumericTransformer() {
                    @Override
                    public int transform(int value) {
                        Thichness_Item.getInstance().setThichness(value);
                        Log.d("ddddddddd", String.valueOf(value));
                        return value ;
                    }
                });
                Log.d("dfdd","dfdfdf");
                dismiss();
            }
        });
        Button cancle=(Button)findViewById(R.id.thickness_cancle);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }



}
