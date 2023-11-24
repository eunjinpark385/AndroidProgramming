package com.example.fragment1_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Log 생성
        Log.i("life-Activity", "onCreate()");

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment1 fragment1 = new Fragment1();
        ft.replace(R.id.rootlayout, fragment1);
        ft.commit();
    }
    // MainActivity Log
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("DlgMain", "onDestroy()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("DlgMain", "onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("DlgMain", "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("DlgMain", "onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("DlgMain", "onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("DlgMain", "onRestart()");
    }
}