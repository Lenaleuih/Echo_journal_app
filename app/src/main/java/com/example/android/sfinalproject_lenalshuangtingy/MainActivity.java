package com.example.android.sfinalproject_lenalshuangtingy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Journal> journal;
    JournalAdapter adapter;

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
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.firstmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.calendarView:
                Intent intent = new Intent(this, CalendarActivity.class);
                startActivity(intent);

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initialData() {

        journal = new ArrayList<>();
        journal.add(new Journal(null,null,"Jun","12", getString(R.string.text1),123));
        journal.add(new Journal(null,null,"Mar","30", getString(R.string.text2),123));
        journal.add(new Journal(null,null,"May","3", getString(R.string.text3),123));

    }


    public void write(View view) {
        Intent msIntent = new Intent(this, EditActivity.class);
        startActivity(msIntent);
    }

    public void viewJournal(View view) {
        Intent msIntent = new Intent(this, ViewActivity.class);
        startActivity(msIntent);
    }
}
