package com.example.ezcook;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myDb = new DatabaseHelper(this);

        Button loginButton = findViewById(R.id.loginButton);
        Button sigupButton = findViewById(R.id.singUpBbutton);
        EditText password = findViewById(R.id.passwordEditText);
        EditText username = findViewById(R.id.usernameEditText);
        loginButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Cursor res = myDb.getAllData();
                boolean flag_ = false;
                StringBuffer buffer = new StringBuffer();
                buffer.append("Record Data...\n");
                while (res.moveToNext()) { //cycle thru result set
                    String usernameWritten = username.getText().toString();
                    String passwordWritten = password.getText().toString();

                    if (usernameWritten.equals(res.getString(4)) && passwordWritten.equals(res.getString(5))){
                        flag_ = true;
                    }
                    buffer.append("Id :" + res.getString(0) + "\n");
                    buffer.append("First Name :" + res.getString(1) + "\n");
                    buffer.append("Last Name :" + res.getString(2) + "\n");
                    buffer.append("Email :" + res.getString(3) + "\n");
                    buffer.append("Username :" + res.getString(4) + "\n");
                    buffer.append("Password :" + res.getString(5) + "\n\n");
                }
                Log.i("Data",  buffer.toString());
                if(flag_){
                    Toast.makeText(LoginActivity.this, "Redirecting...", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Wrong Credentials, try again", Toast.LENGTH_LONG).show();
                }

            }
        });

        sigupButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });

    }
}
