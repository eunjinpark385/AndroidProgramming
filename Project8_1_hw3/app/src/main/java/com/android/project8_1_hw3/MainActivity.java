package com.android.project8_1_hw3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Integer[] posterID = {R.drawable.mov01, R.drawable.mov02,
            R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10, R.drawable.mov01,
            R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07,
            R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
            R.drawable.mov10, R.drawable.mov01, R.drawable.mov02,
            R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10};

    String[] posterTitle = {"토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3","정직한 후보", "나쁜 녀석들",
            "겨울왕국 2", "알라딘", "극한직업", "스파이더맨", "토이스토리4", "호빗3", "제이슨 본",
            "반지의 제왕 3","정직한 후보", "나쁜 녀석들", "겨울왕국 2", "알라딘", "극한직업", "스파이더맨",
            "토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3","정직한 후보", "나쁜 녀석들", "겨울왕국 2",
            "알라딘", "극한직업", "스파이더맨", "토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3",
            "정직한 후보", "나쁜 녀석들", "겨울왕국 2", "알라딘", "극한직업", "스파이더맨"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // LinearLayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, posterID, posterTitle);
        recyclerView.setAdapter(adapter);
    }
}