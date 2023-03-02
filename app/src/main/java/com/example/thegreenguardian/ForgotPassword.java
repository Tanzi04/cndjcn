package com.example.thegreenguardian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

      private EditText editEmail;
      private Button hitRegister;
      private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        mAuth = FirebaseAuth.getInstance();

        editEmail=findViewById(R.id.resetEmail);
        hitRegister=findViewById(R.id.ResetButton);
        progressBar=findViewById(R.id.progressBar);


        hitRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });

    }

    private void resetPassword() {
        String Email= editEmail.getText().toString().trim();

        if(Email.isEmpty()){
            editEmail.setError("Email is required");
            editEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            editEmail.setError("Please enter a valid email address");
            editEmail.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.sendPasswordResetEmail(Email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this, "Check your Email to reset the password", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgotPassword.this,LoginActivity.class));
                }
                else {
                    Toast.makeText(ForgotPassword.this, "Something is wrong.Please enter a valid Email id", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}