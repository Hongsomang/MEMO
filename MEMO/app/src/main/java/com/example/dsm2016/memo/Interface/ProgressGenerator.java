package com.example.dsm2016.memo.Interface;

import com.dd.processbutton.ProcessButton;

import android.os.Handler;

import java.util.Random;

/**
 * Created by dsm2016 on 2018-03-08.
 */

public class ProgressGenerator {
     public interface OnCompleteListener{
         public void oncomplete();
     }
     private OnCompleteListener mListener;
     private int mProgress;

     public ProgressGenerator(OnCompleteListener listener){
         mListener=listener;
     }
     public void start(final ProcessButton button){
         final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgress+=10;
                button.setProgress(mProgress);
                if(mProgress<100){
                    handler.postDelayed(this,generateDelay());
                }else {
                    mListener.oncomplete();
                }
            }
        },generateDelay());
     }
     private Random random=new Random();
     private int generateDelay(){
         return random.nextInt(1000);
     }
}
