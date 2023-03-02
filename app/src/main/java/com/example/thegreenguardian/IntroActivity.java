package com.example.thegreenguardian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {
    private Button HitRegister;
    private Button HitLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introactivity);



        HitLogin=findViewById(R.id.login);
        HitLogin.setOnClickListener(this);
        HitRegister=findViewById(R.id.register);
        HitRegister.setOnClickListener(this);

        HitLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        HitRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.login:
                startActivity(new Intent(this,LoginActivity.class));
        }
    }
}