package com.android.project10_memo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class Note {
    String category;
    String title;
    String contents;
    String createDateStr;

    public Note(String category, String title, String contents) {
        SimpleDateFormat formatter =
                new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.KOREA);
        Date date = new Date();

        this.category = category;
        this.title = title;
        this.contents = contents;
        this.createDateStr = formatter.format(date);
    }
}