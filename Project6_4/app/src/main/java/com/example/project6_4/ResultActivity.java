package com.example.project6_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.pici_icon);
        setTitle("투표 결과");
        Log.i("Result Log", "onCreate()");

        // 앞 화면에서 보낸 투표 결과 값 받기
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rbarID[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
                R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};
        Integer imageField[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7,
                R.drawable.pic8, R.drawable.pic9};

        TextView tvTop = (TextView) findViewById(R.id.tvTop);
        ImageView ivTop = (ImageView) findViewById(R.id.ivTop);
        int maxEntry = 0;
        for (int i = 1; i < voteResult.length; i++) {
            if (voteResult[maxEntry] < voteResult[i])
                maxEntry = i;
        }
        tvTop.setText(imageName[maxEntry]);
        ivTop.setImageResource(imageField[maxEntry]);

        // 텍스트뷰, 레이팅바 아이디 찾기
        for (int i = 0; i < voteResult.length; i++) {
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
        }
        // 텍스트를 해당 그림 이름으로 변경, 별점 변경
        for (int i = 0; i < voteResult.length; i++) {
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Result Log", "onDestroy()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Result Log", "onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Result Log", "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Result Log", "onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Result Log", "onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Result Log", "onRestart()");
    }
}