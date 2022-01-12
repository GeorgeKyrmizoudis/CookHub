package com.example.cookhub.bottom_navigation_implementation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.cookhub.R;
import com.example.cookhub.bottom_navigation_test.AboutActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_search);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_impl);

        bottomNavigationView.setSelectedItemId(R.id.search_impl);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_impl:
                        finish();
                        startActivity(new Intent(getApplicationContext(), BottomNavigationImplementationActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.search_impl:
                        return true;
                    case R.id.favorites_impl:
                        finish();
                        startActivity(new Intent(getApplicationContext(), FavoritesActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile_impl:
                        finish();
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}