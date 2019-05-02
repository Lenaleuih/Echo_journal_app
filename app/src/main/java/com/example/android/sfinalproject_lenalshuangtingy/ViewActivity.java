package com.example.android.sfinalproject_lenalshuangtingy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ViewActivity extends AppCompatActivity {

    private TextView currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        setTitle("On the day when..");

        //display the current time on the layout
        currentTime=(TextView)findViewById(R.id.currentTime);
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        currentTime.setText(date);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.readactivitymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }



    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.markFunction:
//                Intent intent2 = new Intent(this, SettingActivity.class);
//                startActivity(intent2);
                return true;
//to do: do the mark function

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void reEdit(View view) {
        Intent msIntent = new Intent(this, ReEditActivity.class);
        startActivity(msIntent);
    }

    public void launchPrompt(View view) {
        Intent msIntent2 = new Intent(this, PromptActivity.class);
        startActivity(msIntent2);
    }
}
