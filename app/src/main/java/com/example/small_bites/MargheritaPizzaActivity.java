package com.example.small_bites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MargheritaPizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_margherita_pizza);


        if(getSupportActionBar()!= null)
        {
            getSupportActionBar().hide();
        }
    }
}