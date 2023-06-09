package com.erendev.keys;

import static com.erendev.keys.R.*;
import static com.erendev.keys.R.id.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    ViewPageAdapter viewPageAdapter;
    ViewPager2 viewpager2;
    BottomNavigationView bottomNavigationView;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        floatingActionButton = findViewById(id.fab);
        bottomNavigationView =findViewById(bottomNavigation);
        viewpager2 = findViewById(viewpager);
        viewPageAdapter = new ViewPageAdapter(this);
        viewpager2.setAdapter(viewPageAdapter);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == bottom_home){
                    viewpager2.setCurrentItem(0);
                } else if (id == R.id.person) {
                    viewpager2.setCurrentItem(1);
                } else if (id == R.id.search){
                    viewpager2.setCurrentItem(2);
                } else if (id == R.id.settings){
                    viewpager2.setCurrentItem(3);
                }

                return false;
            }
        });

        viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch(position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(bottom_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(id.person).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(id.search).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(id.settings).setChecked(true);
                        break;
                }
                super.onPageSelected(position);
            }
        });


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreatePassword.class);
                startActivity(intent);

            }
        });
    }
}