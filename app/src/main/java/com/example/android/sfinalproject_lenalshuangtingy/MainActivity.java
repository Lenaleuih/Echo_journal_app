package com.example.android.sfinalproject_lenalshuangtingy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Journal> journal;
    JournalAdapter adapter;
    TextView currentDate;
    Journal newEntry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(" ");

        initialData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapter = new JournalAdapter(journal, this);
        recyclerView.setAdapter(adapter);

        //display the current date on the layout
        currentDate = (TextView) findViewById(R.id.currentDate);
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        currentDate.setText(date);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.firstmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.launchSettings:
                Intent intent2 = new Intent(this, SettingActivity.class);
                startActivity(intent2);
                return true;

            case R.id.calendarView:
                Intent intent = new Intent(this, CalendarActivity.class);
                startActivity(intent);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initialData() {

        journal = new ArrayList<>();
        journal.add(new Journal("Jun", "12", getString(R.string.text1), false));
        journal.add(new Journal("Mar", "30", getString(R.string.text2), false));
        journal.add(new Journal("May", "3", getString(R.string.text3), false));

    }


    public void write(View view) {
        Intent msIntent = new Intent(this, EditActivity.class);
        startActivity(msIntent);
    }

    public void viewJournal(View view) {
        Intent msIntent = new Intent(this, ViewActivity.class);
        startActivity(msIntent);
    }


    public void sync(View view) {
        updateJournal();
    }

    public void updateJournal() {
        journal.add(getNewEntry());
        adapter.notifyDataSetChanged();
    }

    private Journal getNewEntry() {
        Intent msIntent = getIntent();
        if ((Journal) msIntent.getSerializableExtra(Keys.NEW_ENTRY_KEY) != null) {
            newEntry = (Journal) msIntent.getSerializableExtra(Keys.NEW_ENTRY_KEY);
        } else {
            newEntry = new Journal("", "", "", false);
        }
        return newEntry;
    }


}
