package com.hansung.android.androidproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Calendar;

public class MonthViewActivity extends AppCompatActivity {
    int year, month;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_view);

        Calendar cl = Calendar.getInstance();
        int lastDate, start_week;
        Intent intent = getIntent(); //Activity Data 수신하기
        year = intent.getIntExtra("Year", 0);
        month = intent.getIntExtra("Month", 0);
        cl.set(Calendar.YEAR, year); //캘린더 설정 코드
        cl.set(Calendar.MONTH, month-1); //현재 月설정
        cl.set(Calendar.DAY_OF_MONTH, 1); //1일로 설정
        lastDate = cl.getActualMaximum(Calendar.DAY_OF_MONTH); //몇일까지 있는 지 확인하기 위한 변수
        start_week = cl.get(Calendar.DAY_OF_WEEK) -1; //요일 Check변수
        String[] item_date = new String[lastDate+start_week];
        TextView text = findViewById(R.id.month);
        text.setText(year + "년 " + month + "월");
        int date = 1;
        for(int i = 0; i < lastDate + start_week; i++) {
            if(start_week > i)
                item_date[i] = "";
            else {
                item_date[i] = Integer.toString(date);
                date++;
            }
        }

        ArrayAdapter<String> dateAdapter = new ArrayAdapter<String>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, item_date);
        GridView grid = (GridView) findViewById(R.id.gridview);
        grid.setAdapter(dateAdapter);
    }
}
/*
참조한 코드
Calender Set : https://blog.naver.com/PostView.naver?blogId=asap0628&logNo=220720089602&redirect=Dlog&widgetTypeCall=true&directAccess=false
Grid View : https://kwanulee.github.io/AndroidProgramming/adapter-view/gridview.html
 */