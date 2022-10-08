package com.example.small_bites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UndhiyuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_undhiyu);

        if(getSupportActionBar()!= null)
        {
            getSupportActionBar().hide();
        }
    }
}