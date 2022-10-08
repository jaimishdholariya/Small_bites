package com.example.small_bites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Chinese extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CardView springroll,schezwannoodles,vegmanchuria,vegmanchowsoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese);


        if(getSupportActionBar()!= null)
        {
            getSupportActionBar().hide();
        }

        springroll = findViewById(R.id.springroll);
        schezwannoodles = findViewById(R.id.schezwannoodles);
        vegmanchuria = findViewById(R.id.vegmanchuria);
        vegmanchowsoup = findViewById(R.id.vegmanchowsoup);


        springroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent springroll = new Intent(Chinese.this,SpringRoll.class);
                startActivity(springroll);
            }
        });

        schezwannoodles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent schezwannoodles = new Intent(Chinese.this,SchezwanNoodles.class);
                startActivity(schezwannoodles);
            }
        });

        vegmanchuria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vegmanchuria = new Intent(Chinese.this,VegManchuria.class);
                startActivity(vegmanchuria);
            }
        });

        vegmanchowsoup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vegmanchowsoup = new Intent(Chinese.this,VegManchowSoup.class);
                startActivity(vegmanchowsoup);
            }
        });

        bottomNavigationView = findViewById(R.id.bottomview);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.dashboard:
                        Intent dashboard = new Intent(Chinese.this,Dashboard.class);
                        startActivity(dashboard);
                        break;


                    case R.id.search:
                        Intent search = new Intent(Chinese.this,Search.class);
                        startActivity(search);
                        break;


                    case R.id.cart:
                        Intent cart = new Intent(Chinese.this,AddCart.class);
                        startActivity(cart);
                        break;

                }
                return true;
            }
        });
    }
}