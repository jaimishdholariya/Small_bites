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

public class Fastfood extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CardView vadapav,dabeli,pavbhaji,momos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastfood);


        if(getSupportActionBar()!= null)
        {
            getSupportActionBar().hide();
        }

        vadapav= findViewById(R.id.vadapav);
        dabeli = findViewById(R.id.dabeli);
        pavbhaji = findViewById(R.id.pavbhaji);
        momos = findViewById(R.id.momos);

        vadapav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vadapav = new Intent(Fastfood.this,VadaPavActivity.class);
                startActivity(vadapav);
            }
        });

        dabeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dabeli = new Intent(Fastfood.this,DabeliActivity.class);
                startActivity(dabeli);
            }
        });

        pavbhaji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pavbhaji = new Intent(Fastfood.this,PavBhajiActivity.class);
                startActivity(pavbhaji);
            }
        });

        momos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent momos = new Intent(Fastfood.this,MomoActivity.class);
                startActivity(momos);
            }
        });



        bottomNavigationView = findViewById(R.id.bottomview);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.dashboard:
                        Intent dashboard = new Intent(Fastfood.this,Dashboard.class);
                        startActivity(dashboard);
                        break;


                    case R.id.search:
                        Intent search = new Intent(Fastfood.this,Search.class);
                        startActivity(search);
                        break;


                    case R.id.cart:
                        Intent cart = new Intent(Fastfood.this,AddCart.class);
                        startActivity(cart);
                        break;

                }
                return true;
            }
        });
    }
}