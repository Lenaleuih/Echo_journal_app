package com.example.android.sfinalproject_lenalshuangtingy;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ViewActivity extends AppCompatActivity {

    private TextView entryTime;
    private TextView entryContent;

    //connect to the database
//    private FirebaseDatabase database;
//    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        setTitle("On the day when..");

        //get the data from previous activity
        Intent mIntent= getIntent();
        String content = mIntent.getStringExtra(Keys.CONTENT_KEY);
        String date = mIntent.getStringExtra(Keys.DATE_KEY);

        //initialize database and reference
//        database = FirebaseDatabase.getInstance();
//        myRef = database.getReference("journal");


        //initialize textViews
        entryTime=(TextView)findViewById(R.id.entryTime);
        entryContent=(TextView)findViewById(R.id.entryContent);

        //retrieve data and display them on the layout
//        myRef.orderByChild("JournalText").equalTo(index).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Journal p = dataSnapshot.getValue(Journal.class);
//                entryTime.setText(p.getJournalMonth()+p.getJournalDay());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        //set the layout
        entryTime.setText(date);
        entryContent.setText(content);
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
        msIntent.putExtra(Keys.DATE_KEY, entryTime.getText().toString());
        msIntent.putExtra(Keys.CONTENT_KEY,entryContent.getText().toString());
        startActivity(msIntent);
    }

    public void launchPrompt(View view) {
        Intent msIntent2 = new Intent(this, PromptActivity.class);
        startActivity(msIntent2);
    }
}