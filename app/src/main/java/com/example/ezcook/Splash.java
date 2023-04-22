package com.example.ezcook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // After 5000 ms the method will be executed
                Intent i = new Intent(Splash.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, 5000);
    }
}
