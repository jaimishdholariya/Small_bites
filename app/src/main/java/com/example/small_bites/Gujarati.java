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

public class Gujarati extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CardView chapati,undheeyu,kajugathiya,mungsabji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gujarati);

        if(getSupportActionBar()!= null)
        {
            getSupportActionBar().hide();
        }

        chapati = findViewById(R.id.chapati);
        undheeyu = findViewById(R.id.undheeyu);
        kajugathiya = findViewById(R.id.kajugatiya);
        mungsabji = findViewById(R.id.mungsabji);

        chapati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chapati = new Intent(Gujarati.this,ChapatiActivity.class);
                startActivity(chapati);
            }
        });

        undheeyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent undheeyu = new Intent(Gujarati.this,UndhiyuActivity.class);
                startActivity(undheeyu);
            }
        });

        kajugathiya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kajugathiya = new Intent(Gujarati.this,KajuGathiyaActivity.class);
                startActivity(kajugathiya);
            }
        });

        mungsabji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mungsabji = new Intent(Gujarati.this,MungSubjiActivity.class);
                startActivity(mungsabji);
            }
        });



        bottomNavigationView = findViewById(R.id.bottomview);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.dashboard:
                        Intent dashboard = new Intent(Gujarati.this,Dashboard.class);
                        startActivity(dashboard);
                        break;


                    case R.id.search:
                        Intent search = new Intent(Gujarati.this,Search.class);
                        startActivity(search);
                        break;


                    case R.id.cart:
                        Intent cart = new Intent(Gujarati.this,AddCart.class);
                        startActivity(cart);
                        break;

                }
                return true;
            }
        });
    }
}