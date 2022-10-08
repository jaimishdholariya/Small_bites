package com.example.small_bites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class PizzaActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CardView cheesepizza,veggiepizza,margheritapiza,pepperonipizza;
    TextView tv_pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);



        if(getSupportActionBar()!= null)
        {
            getSupportActionBar().hide();
        }
        tv_pizza = findViewById(R.id.tv_pizza);
        cheesepizza = findViewById(R.id.cheesepizza);
        veggiepizza = findViewById(R.id.veggiepizza);
        margheritapiza = findViewById(R.id.margheritapizza);
        pepperonipizza = findViewById(R.id.pepperonipizza);

        cheesepizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent veggiepizza = new Intent(PizzaActivity.this,CheesePizza.class);
                startActivity(veggiepizza);
            }
        });

        veggiepizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent veggiepizza = new Intent(PizzaActivity.this,VeggiePizzaActivity.class);
                startActivity(veggiepizza);
            }
        });

        margheritapiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent margheritapizza = new Intent(PizzaActivity.this,MargheritaPizzaActivity.class);
                startActivity(margheritapizza);
            }
        });

        pepperonipizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pepperonipizza = new Intent(PizzaActivity.this,PepperoniPizzaActivity.class);
                startActivity(pepperonipizza);
            }
        });

        bottomNavigationView = findViewById(R.id.bottomview);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.dashboard:
                        Intent dashboard = new Intent(PizzaActivity.this,Dashboard.class);
                        startActivity(dashboard);
                        break;


                    case R.id.search:
                        Intent search = new Intent(PizzaActivity.this,Search.class);
                        startActivity(search);
                        break;


                    case R.id.cart:
                        Intent cart = new Intent(PizzaActivity.this,AddCart.class);
                        startActivity(cart);
                        break;

                }
                return true;
            }
        });
    }
}