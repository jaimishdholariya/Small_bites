package com.example.small_bites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Southindian extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_southindian);


        if(getSupportActionBar()!= null)
        {
            getSupportActionBar().hide();
        }

        bottomNavigationView = findViewById(R.id.bottomview);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.dashboard:
                        Intent dashboard = new Intent(Southindian.this,Dashboard.class);
                        startActivity(dashboard);
                        break;


                    case R.id.search:
                        Intent search = new Intent(Southindian.this,Search.class);
                        startActivity(search);
                        break;


                    case R.id.cart:
                        Intent cart = new Intent(Southindian.this,AddCart.class);
                        startActivity(cart);
                        break;

                }
                return true;
            }
        });
    }
}