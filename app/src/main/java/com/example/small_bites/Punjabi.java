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

public class Punjabi extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CardView paneertikka,naan,kajucurry,vegkadai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punjabi);

        if(getSupportActionBar()!= null)
        {
            getSupportActionBar().hide();
        }
        paneertikka = findViewById(R.id.paneertikka);
        naan = findViewById(R.id.naan);
        kajucurry = findViewById(R.id.kajucurry);
        vegkadai = findViewById(R.id.vegkadai);

        paneertikka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paneertikka = new Intent(Punjabi.this,PaneerTikka.class);
                startActivity(paneertikka);
            }
        });

        naan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent naan = new Intent(Punjabi.this,Naan.class);
                startActivity(naan);
            }
        });

        kajucurry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kajucurry = new Intent(Punjabi.this,KajuCurry.class);
                startActivity(kajucurry);
            }
        });

        vegkadai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vegkadai = new Intent(Punjabi.this,VegKadai.class);
                startActivity(vegkadai);
            }
        });


        bottomNavigationView = findViewById(R.id.bottomview);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.dashboard:
                        Intent dashboard = new Intent(Punjabi.this,Dashboard.class);
                        startActivity(dashboard);
                        break;


                    case R.id.search:
                        Intent search = new Intent(Punjabi.this,Search.class);
                        startActivity(search);
                        break;


                    case R.id.cart:
                        Intent cart = new Intent(Punjabi.this,AddCart.class);
                        startActivity(cart);
                        break;

                }
                return true;
            }
        });
    }
}