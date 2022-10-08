package com.example.small_bites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class Search extends AppCompatActivity {


    RecyclerView recyclerview;
    BottomNavigationView bottomNavigationView;
    ArrayList<SearchModel> arrlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        bottomNavigationView = findViewById(R.id.bottomview);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.dashboard:
                        Intent dashboard = new Intent(Search.this,Dashboard.class);
                        startActivity(dashboard);
                        break;


                    case R.id.cart:
                        Intent cart = new Intent(Search.this,AddCart.class);
                        startActivity(cart);
                        break;

                }
                return true;
            }
        });

        recyclerview = findViewById(R.id.recyclerview);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));


        arrlist.add(new SearchModel(R.drawable.ic_time,"pasta"));
        arrlist.add(new SearchModel(R.drawable.ic_time,"pasta"));
        arrlist.add(new SearchModel(R.drawable.ic_time,"pasta"));
        arrlist.add(new SearchModel(R.drawable.ic_time,"pasta"));
        arrlist.add(new SearchModel(R.drawable.ic_time,"pasta"));


        RecyclerAdapter adapter = new RecyclerAdapter(this,arrlist);

        recyclerview.setAdapter(adapter);


    }

}