package com.erendev.keys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.erendev.keys.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String username = binding.userName.getText().toString();
               String name = binding.name.getText().toString();
               String password = binding.userPassword.getText().toString();

               if(username.equals("") || name.equals("") || password.equals("")){
                   Toast.makeText(SignUpActivity.this, "Fill all required Fields", Toast.LENGTH_SHORT).show();
               } else {
                   if (username.length() > 0) {
                       Boolean checkusername = databaseHelper.checkUsername(username);

                    if (checkusername == false){
                        Boolean insert = databaseHelper.insertData(name, username, password);

                        if (insert == true){
                            Toast.makeText(SignUpActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                            } else {
                            Toast.makeText(SignUpActivity.this,"Registration Failed", Toast.LENGTH_SHORT).show();
                              }

                         } else {
                        Toast.makeText(SignUpActivity.this, "User Already Exists", Toast.LENGTH_SHORT).show();
                       }
                   } else {
                       Toast.makeText(SignUpActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });

        binding.loginRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivty.class);
                startActivity(intent);
            }
        });
    }
}