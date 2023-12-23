package com.android.project10_memo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.project10_memo.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle toggle;
    ActivityMainBinding binding;
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    ThirdFragment thirdFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_MEDIA_IMAGES) == PackageManager.PERMISSION_DENIED) {

                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_MEDIA_IMAGES}, 101);
                Toast.makeText(this, "sdk 33 이상, 권한 설정이 필요합니다.", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "sdk 33 이상, 권한이 있습니다.", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "sdk 32 이하, 권한 설정이 필요합니다.", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 101);
            }
            else {
                Toast.makeText(this, "sdk 32 이하, 권한이 있습니다.", Toast.LENGTH_SHORT).show();
            }
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, R.string.app_name, R.string.app_name);
        toggle.syncState();

        Intent intent = getIntent();
        String abTitle = intent.getStringExtra("UserName");
        setTitle(abTitle +"'s Memo");

        firstFragment = new FirstFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, firstFragment).commit();

        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();

        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.menu_bottom_list) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();
                    return true;
                } else if (id == R.id.menu_bottom_write) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
                    return true;
                } else if (id == R.id.menu_bottom_alarm) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
                    return true;
                }
                return false;
            }
        });

        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.menu_bottom_list){
                    Toast.makeText(MainActivity.this, "목록", Toast.LENGTH_SHORT).show();
                }else if(id==R.id.menu_bottom_write){
                    Toast.makeText(MainActivity.this, "작성", Toast.LENGTH_SHORT).show();
                }else if(id==R.id.menu_bottom_alarm){
                    Toast.makeText(MainActivity.this, "알람", Toast.LENGTH_SHORT).show();
                }
                binding.drawerLayout.closeDrawers();
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}