package com.example.ezcook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button logOutButton;
    ImageButton ingredientsButton;
    ImageButton recipesButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logOutButton = findViewById(R.id.logOutButton);
        ingredientsButton = findViewById(R.id.ingredientsImageButton);
        recipesButton = findViewById(R.id.recipesImageButton);

        logOutButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        /*
        ingredientsButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // PASAR A LA ACTIVIDAD DE INGREDIENTES
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        */
        /*
        recipesButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // PASAR A LA ACTIVIDAD DE RECETAS
                Intent i = new Intent(MainActivity.this, RecipesActivity.class);
                startActivity(i);
            }
        });
        */
    }
}