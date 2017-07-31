package com.example.dsm2016.memo;

/**
 * Created by dsm2016 on 2017-07-31.
 */

public class MemoData {
    private int _id;
    private String title;
    private  String content;
    public int get_id(){
        return _id;
    }
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public void set_id(int _id){
        this._id=_id;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setContent(String content){
        this.content=content;
    }

}
