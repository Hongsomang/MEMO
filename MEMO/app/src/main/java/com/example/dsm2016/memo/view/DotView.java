package com.example.dsm2016.memo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.dsm2016.memo.iteam.Thichness_Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsm2016 on 2018-03-13.
 */

public class DotView extends View {
   // private Paint paint=new Paint();
    private  Paint paint;
    private float x,y,r;
    private List<PosInfo> data;

    public DotView(Context context) {
        super(context);
        data=new ArrayList();
        paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5f);
    }


//    public void setPaintInfo(int color,float  r){
//        paint.setColor(color);
//        this.r=r;
//        Log.d("dfdfdfd", String.valueOf(paint.getColor()));
//        Log.d("dkdkdkdkd",String.valueOf(r));
//    }

    @Override
    protected void onDraw(Canvas canvas) {

        for(PosInfo p : data){
            r=Thichness_Item.getInstance().getThichness();
            canvas.drawCircle(p.getX(),p.getY(),r,paint);
//            canvas.drawCircle(p.getX(),p.getY(),p.getR(),p.getPaint());
//            Log.d("ppppppppppp", String.valueOf(p.getPaint()));
//            Log.d("rrrrrrrrr", String.valueOf(p.getR()));
        }
       // super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x=event.getX();
        y=event.getY();

        PosInfo posInfo=new PosInfo(x,y);

        //posInfo.setPaint(paint);

       // posInfo.setR(r);
        data.add(posInfo);
        invalidate();
        return true;

    }
}
class PosInfo{
    float x,y;
    // private float x,y,r;
    //private Paint paint;


     PosInfo(float x, float y){
         this.x=x;
         this.y=y;
     }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
//    public void setPaint(Paint paint){
//         this.paint=paint;
//    }
//    public Paint getPaint(){
//        return paint;
//    }
//    public float getR(){
//        return r;
//    }
//    public  void setR(float r){
//        this.r=r;
//    }
}