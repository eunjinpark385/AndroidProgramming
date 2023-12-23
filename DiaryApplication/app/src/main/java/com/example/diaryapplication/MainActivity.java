package com.example.diaryapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.diaryapplication.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

/*
프로그램 제목 : Diary Application
학번 : 2020111385
이름 : 박은진
작성 날짜 : 2023-12-22
*/
public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle toggle;
    // MainActivity ViewBinding
    ActivityMainBinding binding;
    // Fragment
    ListFragment listFragment;
    WriteFragment writeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Login Activity 에서 사용자 이름 정보 받아와 타이틀 설정
        Intent intent = getIntent();
        String abTitle = intent.getStringExtra("UserName");
        setTitle(abTitle + "'s Diary");

        listFragment = new ListFragment();
        writeFragment = new WriteFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, listFragment).commit();

        // Bottom Navigation Bar 사용
        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.menu_bottom_list) { // '목록' 메뉴 선택 시 list_fragment 로 변경
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, listFragment).commit();
                    return true;
                }
                else if (id == R.id.menu_bottom_write) { // '작성' 메뉴 선택 시 write_fragment 로 변경
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, writeFragment).commit();
                    return true;
                }
                return false;
            }
        });

        // Navigation Drawer 사용
        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.menu_bottom_list) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, listFragment).commit();
                    return true;
                }
                else if (id == R.id.menu_bottom_write) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, writeFragment).commit();
                    return true;
                }
                binding.drawerLayout.closeDrawers();
                return false;
            }
        });
        // ActionBar Toggle 생성
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, R.string.app_name, R.string.app_name);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}