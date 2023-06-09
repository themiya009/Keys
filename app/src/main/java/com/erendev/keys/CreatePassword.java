package com.erendev.keys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class CreatePassword extends AppCompatActivity {

    Button saveBtn, backBtn;
    EditText pNamein, usrPwdin, usrDescin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

        saveBtn = findViewById(R.id.saveBtn);
        backBtn = findViewById(R.id.backBtn);
        pNamein = findViewById(R.id.editTextPlatform);
        usrPwdin = findViewById(R.id.editTextTextPassword);
        usrDescin = findViewById(R.id.editTextDesc);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pName = pNamein.getText().toString();
                String usrPwd = usrPwdin.getText().toString();
                String usrDesc = usrDescin.getText().toString();

                realm.beginTransaction();
                PasswordModel passwordModel = realm.createObject(PasswordModel.class);
                passwordModel.setpName(pName);
                passwordModel.setUsrPwd(usrPwd);
                passwordModel.setUsrDesc(usrDesc);

                realm.commitTransaction();

                Toast.makeText(getApplicationContext(), "Password Saved", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreatePassword.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}