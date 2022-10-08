package com.example.small_bites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VegKadai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg_kadai);

        if(getSupportActionBar()!= null)
        {
            getSupportActionBar().hide();
        }
    }
}