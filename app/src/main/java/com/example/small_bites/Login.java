package com.example.small_bites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText email, password;
    Button login;
    TextView forget, register;
    String emailpatten = "[A_Za-z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        setContentView(R.layout.activity_login);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        login = (Button) findViewById(R.id.login);
        forget = (TextView) findViewById(R.id.forget);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        register = (TextView) findViewById(R.id.register);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Register = new Intent(Login.this, Register.class);
                startActivity(Register);
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forget = new Intent(Login.this, Forgot.class);
                startActivity(forget);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perforauth();
            }
        });
    }

    private void perforauth() {

        String Email = email.getText().toString();
        String Password = password.getText().toString();


        if (!Email.matches(emailpatten)) {
            email.setError("Please Valid Email");
        } else if (Password.isEmpty() || Password.length() < 6) {
            password.setError("Please proper Password");
        } else {
            progressDialog.setMessage("Please Waiting....");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        sendUserToNextActivvity();
                        Toast.makeText(Login.this, "Login", Toast.LENGTH_SHORT).show();
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(Login.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivvity() {

        Intent Main = new Intent(Login.this, Dashboard.class);
        startActivity(Main);
    }

    @Override
    public void onStart() {

        super.onStart();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent i = new Intent(Login.this, Dashboard.class);
            startActivity(i);
            finish();
        }
    }
}
