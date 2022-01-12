package com.example.cookhub.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookhub.R;
import com.example.cookhub.adapters.MainMenuAdapter;
import com.example.cookhub.models.MainMenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_constraint);
        setContentView(R.layout.activity_main_layout);

    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_recipes);
        recyclerView.setAdapter(new MainMenuAdapter(getDataList(), this, new MainMenuAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, MainMenuItem data) {
                /*Snackbar.make(v, "Go to new Fragment and call the API with param: " + data.getItemName(), Snackbar.LENGTH_SHORT).show();*/

                //TODO comment it out
                Intent intent = new Intent(MainActivity.this, RecipeCategoryActivity.class);
                intent.putExtra("recipeCategory",data.getItemName());
                startActivity(intent);
            }
        }));


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home_impl);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_impl:
                        return true;
                    case R.id.search_impl:
                        finish();
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.favorites_impl:
                        /*finish();
                        startActivity(new Intent(getApplicationContext(), FavoritesActivity.class));
                        overridePendingTransition(0,0);*/
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

    private ArrayList<MainMenuItem> getDataList(){
        ArrayList<MainMenuItem> mainMenuList = new ArrayList<>();
        mainMenuList.add(new MainMenuItem("Cookies", R.drawable.biscuits));
        mainMenuList.add(new MainMenuItem("Bread", R.drawable.bread));
        mainMenuList.add(new MainMenuItem("Cereals", R.drawable.cereals));
        mainMenuList.add(new MainMenuItem("Sauces", R.drawable.sauce));
        mainMenuList.add(new MainMenuItem("Desserts", R.drawable.dessert));
        mainMenuList.add(new MainMenuItem("Drinks", R.drawable.drinks));
        mainMenuList.add(new MainMenuItem("Main course", R.drawable.main_course));
        mainMenuList.add(new MainMenuItem("Pancakes", R.drawable.pancakes));
        mainMenuList.add(new MainMenuItem("Preps", R.drawable.preps));
        mainMenuList.add(new MainMenuItem("Preserves", R.drawable.preserve));
        mainMenuList.add(new MainMenuItem("Salads", R.drawable.salad));
        mainMenuList.add(new MainMenuItem("Sandwiches", R.drawable.sandwiches));
        mainMenuList.add(new MainMenuItem("Side dishes", R.drawable.side_dish));
        mainMenuList.add(new MainMenuItem("Soups", R.drawable.soup));
        mainMenuList.add(new MainMenuItem("Starter", R.drawable.starter));
        mainMenuList.add(new MainMenuItem("Sweets", R.drawable.sweets));
        return mainMenuList;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
