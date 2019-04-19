package com.example.android.sfinalproject_lenalshuangtingy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ReEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_edit);

        setTitle("Say to yourself in the past");
    }

    public void saveComment(View view) {
        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
    }
}
