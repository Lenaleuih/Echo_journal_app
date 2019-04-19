package com.example.android.sfinalproject_lenalshuangtingy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        setTitle("Write down your thoughts");
    }

    public void saveJournal(View view) {
        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
    }
}
