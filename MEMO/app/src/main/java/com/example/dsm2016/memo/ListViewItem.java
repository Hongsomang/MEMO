package com.example.dsm2016.memo;

import android.graphics.drawable.Drawable;
import android.widget.EditText;

import java.util.Date;

/**
 * Created by dsm2016 on 2017-07-24.
 */

public class ListViewItem {

    private String titleStr;
    private String dateStr;


    public void setTitleStr(EditText title){
        titleStr=title;
    }
    public void setDateStr(Date date){
        dateStr=date;
    }

    public String getTitle(){
        return this.titleStr;
    }
    public String getDate(){
        return this.dateStr;
    }
}
