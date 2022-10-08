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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Forgot extends AppCompatActivity {

    EditText email_address;
    TextView back_login;
    Button forget_password;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    String Email;
    ProgressDialog progressdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        if(getSupportActionBar()!= null)
        {
            getSupportActionBar().hide();
        }

        email_address = (EditText)findViewById(R.id.email_address);
        back_login = (TextView)findViewById(R.id.back_login);
        forget_password = (Button)findViewById(R.id.forget_password);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        progressdialog = new ProgressDialog(this);

        back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Forgot.this,Login.class);
                startActivity(back);
            }
        });

        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    private void validate() {

        Email = email_address.getText().toString();

        if(Email.isEmpty())
        {
            email_address.setError("Required");
        }
        else
        {
            progressdialog.setMessage("Please Waiting....");
            progressdialog.setTitle("Forget_Password");
            progressdialog.setCanceledOnTouchOutside(false);
            progressdialog.show();

            mAuth.sendPasswordResetEmail(Email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {
                        progressdialog.dismiss();
                        sendToNextActivity();
                        Toast.makeText(Forgot.this,"Check Your Spam Email",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        progressdialog.dismiss();
                        Toast.makeText(Forgot.this,"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }



    private void sendToNextActivity() {

        Intent forget = new Intent(Forgot.this,Login.class);
        startActivity(forget);
    }
}
