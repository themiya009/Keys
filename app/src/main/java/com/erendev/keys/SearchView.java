package com.erendev.keys;

import static com.erendev.keys.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import io.realm.Realm;
import io.realm.RealmResults;

public class SearchView extends AppCompatActivity {

    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_search_view);

        textView = findViewById(id.searchKey);

        Intent intent = getIntent();
        String searchID = intent.getStringExtra("searchKey");
        textView.setText(searchID);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        RealmResults<PasswordModel> passwdlist = realm.where(PasswordModel.class).contains("pName", searchID ).findAll();

        RecyclerView recyclerView = findViewById(R.id.searchView)
                ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getApplicationContext(),passwdlist);
        recyclerView.setAdapter(recyclerAdapter);
    }
}