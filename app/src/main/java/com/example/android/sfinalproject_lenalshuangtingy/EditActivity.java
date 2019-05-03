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

public class EditActivity extends AppCompatActivity {

    private TextView currentTime;
    private String prompts;
    private EditText content;
    private String entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        setTitle("Write down your thoughts");

        content = (EditText) findViewById(R.id.input);

        //display the current time on the layout
        currentTime=(TextView)findViewById(R.id.currentTime);
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        currentTime.setText(date);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.editactivitymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void launchPrompt(View view) {
        Intent msIntent = new Intent(this, PromptActivity.class);
        startActivityForResult(msIntent,111);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 111 && resultCode == RESULT_OK) {
            prompts = data.getStringExtra(Keys.PROMPT_KEY);
            content.setText(prompts);
        }
    }

    public void saveText(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        entry=content.getText().toString();
        intent.putExtra("WHOLE_ENTRY", entry);

        startActivity(intent);


    }
}
