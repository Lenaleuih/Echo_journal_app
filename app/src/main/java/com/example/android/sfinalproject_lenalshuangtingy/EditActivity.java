package com.example.android.sfinalproject_lenalshuangtingy;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class EditActivity extends AppCompatActivity {

    private TextView currentTime;
    private String prompts;
    private EditText content;
    private String entry;
    private Boolean marked;
    private Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        setTitle(" ");

        marked = false;

        content = (EditText) findViewById(R.id.input);

        //display the current time on the layout
        currentTime = (TextView) findViewById(R.id.currentTime);
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        currentTime.setText(date);


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.editactivitymenu, menu);
        this.menu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.markFunction:
                marked = true;
                menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.blackbookmark));
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void launchPrompt(View view) {
        Intent msIntent = new Intent(this, PromptActivity.class);
        startActivityForResult(msIntent, 111);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 111 && resultCode == RESULT_OK) {
            prompts = data.getStringExtra(Keys.PROMPT_KEY);
            content.setText(prompts);
        }
    }

    public void saveText(View view) {
        entry = content.getText().toString();

        SimpleDateFormat df2 = new SimpleDateFormat("MMM");
        String month_name = df2.format(Calendar.getInstance().getTime());
        SimpleDateFormat df3 = new SimpleDateFormat("d");
        String day_name = df3.format(Calendar.getInstance().getTime());

        Journal j = new Journal(month_name, day_name, entry, marked);


        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Keys.NEW_ENTRY_KEY, j);


        startActivity(intent);


    }
}
