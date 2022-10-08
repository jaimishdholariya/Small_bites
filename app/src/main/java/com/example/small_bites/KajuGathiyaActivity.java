package com.example.small_bites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class KajuGathiyaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaju_gathiya);

        if(getSupportActionBar()!= null)
        {
            getSupportActionBar().hide();
        }
    }
}