package com.spaceo.recyclerviewdemo;

/**
 * Created by Khyati on 12/5/17.
 */

public class NewsModel {
    private String title,date;

    public NewsModel(String title,String date){
        this.title=title;
        this.date=date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
