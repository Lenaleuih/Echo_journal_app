package com.example.android.sfinalproject_lenalshuangtingy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReEditActivity extends AppCompatActivity {

    private TextView currentTime;
    private TextView previousContent;
    private String prompts;
    private EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_edit);

        content = (EditText) findViewById(R.id.reEditContent);
        currentTime = (TextView) findViewById(R.id.currentTime);
        previousContent =(TextView) findViewById(R.id.previousContent);


        //have i successfully committed??
        //receive data from previous event
        Intent mIntent= getIntent();
        String passedContent = mIntent.getStringExtra(Keys.CONTENT_KEY);
        //String date = mIntent.getStringExtra(Keys.DATE_KEY);

        previousContent.setText(passedContent);

        //get current date
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");
        String currentDate = df.format(Calendar.getInstance().getTime());
        currentTime.setText(currentDate);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reeditactivitymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void saveComment(View view) {
        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
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
}
