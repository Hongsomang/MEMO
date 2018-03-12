package com.example.dsm2016.memo.iteam;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

/**
 * Created by dsm2016 on 2018-03-12.
 */

public class Thichness_Item {
    private int thichness;

    public int getThichness() {
        return thichness;
    }

    public void setThichness(int  thichness) {
        this.thichness = thichness;
    }
    public static Thichness_Item instance=null;
    public static synchronized Thichness_Item getInstance(){
        if(null==instance){
            instance=new Thichness_Item();
        }
        return instance;
    }
}

