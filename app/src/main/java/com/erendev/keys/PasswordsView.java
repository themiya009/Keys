package com.erendev.keys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class PasswordsView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwords_view);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        RealmResults<PasswordModel> passwdlist = realm.where(PasswordModel.class).findAll();

        RecyclerView recyclerView = findViewById(R.id.pwd_view)
;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getApplicationContext(),passwdlist);
        recyclerView.setAdapter(recyclerAdapter);

        passwdlist.addChangeListener(new RealmChangeListener<RealmResults<PasswordModel>>() {
            @Override
            public void onChange(RealmResults<PasswordModel> passwordModels) {
                recyclerAdapter.notifyDataSetChanged();
            }
        });
    }
}