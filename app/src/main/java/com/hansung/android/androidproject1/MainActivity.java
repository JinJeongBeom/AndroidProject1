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

    @Override
    protected void onRestart() { //엑티비티 재실행 시 끄는 코드
        super.onRestart();
        finish();
    }

}
/*
참조한 코드
Calender Class : https://moonong.tistory.com/10
Intent 및 Activity간 통신 : https://kwanulee.github.io/AndroidProgramming/activity-intent/exercise5.html
엑티비티 종료 : https://hashcode.co.kr/questions/1885/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%A1%ED%8B%B0%EB%B9%84%ED%8B%B0-%EC%A2%85%EB%A3%8C
엑티비티 수명주기 : https://kwanulee.github.io/AndroidProgramming/activity-intent/activity-lifecycle.html
*/