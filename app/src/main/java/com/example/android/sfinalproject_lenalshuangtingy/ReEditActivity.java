package com.example.android.sfinalproject_lenalshuangtingy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReEditActivity extends AppCompatActivity {

    private TextView currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_edit);


        currentTime = (TextView) findViewById(R.id.currentTime);
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        currentTime.setText(date);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reeditactivitymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void saveComment(View view) {
        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
    }
}
