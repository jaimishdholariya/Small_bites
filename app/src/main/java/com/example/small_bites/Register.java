package com.example.small_bites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText email,password,cpassword;
    Button register;
    TextView login;
    String emailpatten = "[A_Za-z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseDatabase database;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if(getSupportActionBar()!= null)
        {
            getSupportActionBar().hide();
        }

        email =(EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        cpassword = (EditText)findViewById(R.id.cpassword);
        register = (Button)findViewById(R.id.register);
        login = (TextView)findViewById(R.id.login);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Login = new Intent(Register.this,Login.class);
                startActivity(Login);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perforauth();
            }
        });
    }

    private void perforauth() {
        String Email = email.getText().toString();
        String Password = password.getText().toString();
        String Cpassword = cpassword.getText().toString();


        if(!Email.matches(emailpatten))
        {
            email.setError("Please Valid Email");
        }
        else if(Password.isEmpty() || Password.length()<6)
        {
            password.setError("Please proper Password");
        }
        else if(!Password.equals(Cpassword))
        {
            cpassword.setError("Please do not match Password");
        }
        else
        {
            progressDialog.setMessage("Please Waiting....");
            progressDialog.setTitle("Registation");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendUserToNextActivvity();
                        Toast.makeText(Register.this,"Registation",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(Register.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivvity() {

        Intent Main = new Intent(Register.this,Login.class);
        startActivity(Main);
        finish();
    }
}