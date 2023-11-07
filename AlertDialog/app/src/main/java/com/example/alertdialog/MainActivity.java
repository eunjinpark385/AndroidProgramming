package com.example.alertdialog;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("DlgMain", "onCreate()");


        final Button dlgBtn = (Button) findViewById(R.id.dlgBtn);
        dlgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog_custom, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("대화상자 제목");
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });
    }

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