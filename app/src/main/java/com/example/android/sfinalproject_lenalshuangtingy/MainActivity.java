package com.example.android.sfinalproject_lenalshuangtingy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.SearchView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ArrayList<Journal> journals;
    JournalAdapter babyAdapter;
    TextView currentDate;
    Journal newEntry;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private RecyclerView babyRecyclerView;
    private Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(" ");


        babyRecyclerView = findViewById(R.id.recycler_view);
        babyRecyclerView.setHasFixedSize(true);
        babyRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //read data from firebase
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("journal");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                journals = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Journal p = dataSnapshot1.getValue(Journal.class);
                    journals.add(p);
                }
                babyAdapter = new JournalAdapter(journals, MainActivity.this);
                babyRecyclerView.setAdapter(babyAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Opsss...Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });

        //display the current date on the layout
        currentDate = (TextView) findViewById(R.id.currentDate);
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        currentDate.setText(date);


    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.firstmenu, menu);
        this.menu = menu;

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);

        return true;
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


            case R.id.markFunction:
                menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.blackbookmark));
                myRef.orderByChild("marked").equalTo(true).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        journals = new ArrayList<>();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            Journal p = dataSnapshot1.getValue(Journal.class);
                            journals.add(p);
                        }
                        babyAdapter = new JournalAdapter(journals, MainActivity.this);
                        babyRecyclerView.setAdapter(babyAdapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
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
        journals.add(getNewEntry());
        myRef.push().setValue(getNewEntry());
        babyAdapter.notifyDataSetChanged();

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


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String input = newText.toLowerCase();
        myRef.orderByChild("journalText").startAt(input)
                .endAt(input+"\uf8ff").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    journals = new ArrayList<>();
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        Journal p = dataSnapshot1.getValue(Journal.class);
                        journals.add(p);
                    }
                    babyAdapter = new JournalAdapter(journals, MainActivity.this);
                    babyRecyclerView.setAdapter(babyAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return false;
    }
}