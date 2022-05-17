package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtWelcome = findViewById(R.id.txtWelcome);

        Intent intent2 = getIntent();
        String fullname = intent2.getStringExtra("fullname");
        txtWelcome.setText("Welcome, "+fullname);
    }
}