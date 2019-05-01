package com.example.android.sfinalproject_lenalshuangtingy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.ArrayList;

public class CalendarActivity extends AppCompatActivity {

    public static final String RESULT = "result";
    //public static final String EVENT = "event";
    //private static final int ADD_NOTE = 44;

    private CalendarView mCalendarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        setTitle("Calendar");

        mCalendarView = (CalendarView) findViewById(R.id.calendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Intent msIntent = new Intent(CalendarActivity.this, ViewActivity.class);
                startActivity(msIntent);

            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;

            case R.id.launchSettings2:
                Intent intent2 = new Intent(this, SettingActivity.class);
                startActivity(intent2);
                return true;

//            case R.id.calendarView:
//                Intent intent = new Intent(this, CalendarActivity.class);
//                startActivity(intent);
//                return true;
            // to do: search function


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.secondmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void write(View view) {
        Intent msIntent = new Intent(this, EditActivity.class);
        startActivity(msIntent);
    }
}
