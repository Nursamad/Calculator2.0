package com.example.calculatorgeek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    private String getText;
    private TextView result_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        getText = (String) intent.getSerializableExtra("tvResult");

        result_activity = findViewById(R.id.result_activity);
        result_activity.setText(getText);
        Toast.makeText(this, getText, Toast.LENGTH_SHORT).show();


    }
}