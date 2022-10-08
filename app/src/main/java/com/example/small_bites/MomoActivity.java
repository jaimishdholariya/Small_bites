package com.example.small_bites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MomoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_momo);

        if(getSupportActionBar()!= null)
        {
            getSupportActionBar().hide();
        }
    }
}