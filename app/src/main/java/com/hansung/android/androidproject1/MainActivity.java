package com.hansung.android.androidproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar today = Calendar.getInstance(); //현재 시각 가져오기
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH);
        Intent intent = new Intent(getApplicationContext(), MonthViewActivity.class);
        intent.putExtra("Year", year);
        intent.putExtra("Month", month+1);
        startActivity(intent);
    }
}
/*
참조한 코드
Calender Class : https://moonong.tistory.com/10
Intent 및 Activity간 통신 : https://kwanulee.github.io/AndroidProgramming/activity-intent/exercise5.html
*/