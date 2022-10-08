package com.example.small_bites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CardView pizza,fastfood,punjabi,gujaratidish,chinese,southindian;
    ImageView ic_back;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        if(getSupportActionBar()!= null)
        {
            getSupportActionBar().hide();
        }

        southindian = findViewById(R.id.southindian);
        gujaratidish = findViewById(R.id.gujaratidish);
        chinese = findViewById(R.id.chinese);
        pizza = findViewById(R.id.pizza);
        fastfood = findViewById(R.id.fastfood);
        punjabi = findViewById(R.id.punjabi);
        ic_back = findViewById(R.id.ic_back);
        mAuth = FirebaseAuth.getInstance();


        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pizza = new Intent(Dashboard.this,PizzaActivity.class);
                startActivity(pizza);
            }
        });

        fastfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fastfood = new Intent(Dashboard.this,Fastfood.class);
                startActivity(fastfood);
            }
        });

        punjabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pizza = new Intent(Dashboard.this,Punjabi.class);
                startActivity(pizza);
            }
        });
        gujaratidish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gujarati = new Intent(Dashboard.this,Gujarati.class);
                startActivity(gujarati);
            }
        });

        chinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chinese = new Intent(Dashboard.this,Chinese.class);
                startActivity(chinese);
            }
        });

        southindian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent southindian = new Intent(Dashboard.this,Southindian.class);
                startActivity(southindian);
            }
        });

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent signout = new Intent(Dashboard.this,Login.class);
                startActivity(signout);
            }
        });

        bottomNavigationView = findViewById(R.id.bottomview);

       bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               switch (item.getItemId())
               {
                   case R.id.search:
                       Intent search = new Intent(Dashboard.this,Search.class);
                       startActivity(search);
                       break;


                   case R.id.cart:
                       Intent cart = new Intent(Dashboard.this,AddCart.class);
                       startActivity(cart);
                       break;

               }
               return true;
           }
       });
    }
}