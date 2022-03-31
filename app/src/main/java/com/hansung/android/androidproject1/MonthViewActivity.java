package com.hansung.android.androidproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

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

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(!adapterView.getAdapter().getItem(i).equals(""))
                    Toast.makeText(MonthViewActivity.this, Integer.toString(year) + "." + Integer.toString(month) + "." + adapterView.getAdapter().getItem(i), Toast.LENGTH_SHORT).show();
            }
        });

        Button prevBtn = findViewById(R.id.prevMonth);
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                if(month > 1) {
                    month -= 1;
                }
                else{
                    year -= 1;
                    month = 12;
                }
                Intent intent = new Intent(getApplicationContext(), MonthViewActivity.class);
                intent.putExtra("Year", year);
                intent.putExtra("Month", month);
                startActivity(intent);
            }
        });
        Button nextBtn = findViewById(R.id.nextMonth);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                if(month < 12) {
                    month += 1;
                }
                else{
                    year += 1;
                    month = 1;
                }
                Intent intent = new Intent(getApplicationContext(), MonthViewActivity.class);
                intent.putExtra("Year", year);
                intent.putExtra("Month", month);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
/*
참조한 코드
Calender Set : https://blog.naver.com/PostView.naver?blogId=asap0628&logNo=220720089602&redirect=Dlog&widgetTypeCall=true&directAccess=false
Grid View : https://kwanulee.github.io/AndroidProgramming/adapter-view/gridview.html
Grid View Toast : https://nexthops.tistory.com/40
 */