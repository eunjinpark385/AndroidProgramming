package com.example.diaryapplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Note {
    String category;
    String title;
    String contents;
    String createDateStr;

    public Note(String category, String title, String contents) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
        Date date = new Date();

        this.category = category;
        this.title = title;
        this.contents = contents;
        this.createDateStr = formatter.format(date);
    }

    // getter and setter methods
    public void setCategory(String category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }
}
