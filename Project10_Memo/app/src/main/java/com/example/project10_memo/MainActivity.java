package com.example.project10_memo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.project10_memo.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle toggle;
    ActivityMainBinding binding;
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    ThirdFragment thirdFragment;
    FourthFragment fourthFragment;
    FifthFragment fifthFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String abTitle = intent.getStringExtra("UserName");
        setTitle(abTitle + "'s Memo");

        firstFragment = new FirstFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, firstFragment).commit();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();
        fourthFragment = new FourthFragment();
        fifthFragment = new FifthFragment();

        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.menu_bottom_list) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,firstFragment).commit();
                    return true;
                }
                else if (id == R.id.menu_bottom_write) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
                    return true;
                }
                else if (id == R.id.menu_bottom_alarm) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
                    return true;
                }
                return false;
            }
        });

        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.menu_navigation_userInfo)
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fourthFragment).commit();
                else if (id == R.id.menu_navigation_setting)
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fifthFragment).commit();
                binding.drawerLayout.closeDrawers();
                return false;
            }
        });

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