package com.example.dsm2016.memo.iteam;

/**
 * Created by dsm2016 on 2018-03-06.
 */

public class main_item {
    private String title;
    private String day;

    public main_item(String title, String day) {
        this.title = title;
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
