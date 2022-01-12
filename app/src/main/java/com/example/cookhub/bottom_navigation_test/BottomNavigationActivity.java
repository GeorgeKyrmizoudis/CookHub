package com.example.cookhub.bottom_navigation_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.cookhub.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_test);

        bottomNavigationView.setSelectedItemId(R.id.home);

       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.dashboard:
                       finish();
                       startActivity(new Intent(getApplicationContext(), DashBoardActivity.class));
                       overridePendingTransition(0,0);
                       return true;
                   case R.id.home:
                       return true;
                   case R.id.about:
                       finish();
                       startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                       overridePendingTransition(0,0);
                       return true;
               }
               return false;
           }
       });
    }
}