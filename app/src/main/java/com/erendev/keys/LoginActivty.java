package com.erendev.keys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.erendev.keys.databinding.ActivityLoginActivtyBinding;

public class LoginActivty extends AppCompatActivity {

    ActivityLoginActivtyBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginActivtyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.loginUsername.getText().toString();
                String password = binding.loginPassword.getText().toString();

                if (username.equals("") || password.equals("")){
                    Toast.makeText(LoginActivty.this, "Username and Password cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkCredentials = databaseHelper.checkPassword(username, password);
                     if (checkCredentials == true){
                         Toast.makeText(LoginActivty.this, "Login Successful", Toast.LENGTH_SHORT).show();
                         Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                         startActivity(intent);
                         finish();
                     } else {
                         Toast.makeText(LoginActivty.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                     }
                }
            }
        });

        binding.signupRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}