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

public class SignUpActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    EditText firstNameEditText, lastNameEditText, emailEditText, usernameSignUpEditText,passwordSignUpEditText, confirmPasswordSignUpEditText;
    Button signUpButton;
    boolean isInserted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        myDb = new DatabaseHelper(this);

        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        usernameSignUpEditText = findViewById(R.id.usernameSignUpEditText);
        passwordSignUpEditText = findViewById(R.id.passwordSignUpEditText);
        confirmPasswordSignUpEditText = findViewById(R.id.confirmPasswordSignUpEditText);
        signUpButton = findViewById(R.id.signUpSignUpButton);

        signUpButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Cursor res = myDb.getAllData();
                boolean flag_ = true;
                while (res.moveToNext()) { //cycle thru result set
                    if (usernameSignUpEditText.getText().toString().equals(res.getString(4))){
                        flag_ = false;
                    }
                }

                if (passwordSignUpEditText.getText().toString().equals(confirmPasswordSignUpEditText.getText().toString()) && flag_){
                    isInserted = myDb.insertData(firstNameEditText.getText().toString(),lastNameEditText.getText().toString(),
                            emailEditText.getText().toString(),usernameSignUpEditText.getText().toString(),
                            passwordSignUpEditText.getText().toString());

                    Log.i("Add",  "record added \n");

                    StringBuffer buffer = new StringBuffer();
                    buffer.append("Record Data...\n");
                    while (res.moveToNext()) { //cycle thru result set
                        buffer.append("Id :" + res.getString(0) + "\n");
                        buffer.append("First Name :" + res.getString(1) + "\n");
                        buffer.append("Last Name :" + res.getString(2) + "\n");
                        buffer.append("Email :" + res.getString(3) + "\n");
                        buffer.append("Username :" + res.getString(4) + "\n");
                        buffer.append("Password :" + res.getString(5) + "\n\n");
                    }
                    // Show all data
                    Log.i("Data",  buffer.toString());


                    Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(SignUpActivity.this, "Some value is incorrect. Try fill the form again.", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
