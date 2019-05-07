package com.example.android.sfinalproject_lenalshuangtingy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class PromptActivity extends AppCompatActivity {

    String prompts;
    CheckBox prompt1;
    CheckBox prompt2;
    CheckBox prompt3;
    CheckBox prompt4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);

        setTitle("some questions you may ask yourself");

        prompt1 = (CheckBox) findViewById(R.id.prompt1btn);
        prompt2 = (CheckBox) findViewById(R.id.prompt2btn);
        prompt3 = (CheckBox) findViewById(R.id.prompt3btn);
        prompt4 = (CheckBox) findViewById(R.id.prompt4btn);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.prompt1btn:
                if (checked) {
                    prompts = prompt1.getText().toString();
                } else {
                    prompts = "";
                }
                break;
            case R.id.prompt2btn:
                if (checked) {
                    prompts = prompts + "\n" + prompt2.getText().toString();
                } else {
                    prompts = prompts + "";
                }
                break;
            case R.id.prompt3btn:
                if (checked) {
                    prompts = prompts + "\n" + prompt3.getText().toString();
                } else {
                    prompts = prompts + "";
                }
                break;
            case R.id.prompt4btn:
                if (checked) {
                    prompts = prompts + "\n" + prompt4.getText().toString();
                } else {
                    prompts = prompts + "";
                }
                break;

        }
    }


    public void sendPrompt(View view) {
        Intent data = new Intent();
        data.putExtra(Keys.PROMPT_KEY, prompts);
        setResult(RESULT_OK, data);
        finish();
    }
}