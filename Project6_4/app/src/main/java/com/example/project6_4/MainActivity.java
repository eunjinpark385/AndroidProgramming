package com.example.project6_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.pici_icon);
        setTitle("명화 선호도 투표");
        // 로그 남기기
        Log.i("Main Log", "onCreate()");

        // 9개의 이미지 투표 결과
        int voteCount[] = new int[9];
        for (int i = 0; i < 9; i++)
            voteCount[i] = 0;
        // 9개의 이미지 버튼 객체 배열
        ImageView image[] = new ImageView[9];
        // 9개의 이미지 버튼 ID 배열
        Integer imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
        // 9개의 이미지 이름 배열
        String imgName[] = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매",
                "피아노 레슨", "피아노 앞의 소녀들", "해변에서"};

        // 이미지 클릭 동작 핸들러
        for (int i = 0; i < imageId.length; i++) {
            final int index;
            index = i;
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { // 해당 이미지 클릭할 때마다
                    voteCount[index]++; // 카운트 증가
                    Toast.makeText(getApplicationContext(),
                            imgName[index] + ": 총 " + voteCount[index] + " 표",
                            Toast.LENGTH_SHORT).show(); // 토스트 메시지 출력
                }
            });
        }

        // 버튼 핸들러
        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 버튼 클릭 시
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class); // 인텐트 생성
                intent.putExtra("VoteCount", voteCount); // 득표수 데이터 전달
                intent.putExtra("ImageName", imgName); // 이미지 이름 데이터 전달
                startActivity(intent); // ResultActivity 실행
            }
        });
    }

    // MainActivity 생명 주기 로그 남기기
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Main Log", "onDestroy()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Main Log", "onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Main Log", "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Main Log", "onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Main Log", "onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Main Log", "onRestart()");
    }
}