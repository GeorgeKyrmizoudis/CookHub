package com.example.cookhub.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookhub.R;
import com.example.cookhub.models.MainMenuItem;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        RecyclerView cuisineRecycler = findViewById(R.id.recycler_view_cuisines);
        cuisineRecycler.setAdapter(new CuisineAdapter(getCuisineList(), this, new CuisineAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, MainMenuItem data) {
                Intent intent = new Intent(SearchActivity.this, RecipeCategoryActivity.class);
                intent.putExtra("recipeCategory",data.getItemName());
                startActivity(intent);
            }
        }));

        RecyclerView dishTypeRecycler = findViewById(R.id.recycler_view_dish_type);
        dishTypeRecycler.setAdapter(new CuisineAdapter(getMealList(), this, new CuisineAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, MainMenuItem data) {
                Intent intent = new Intent(SearchActivity.this, RecipeCategoryActivity.class);
                intent.putExtra("recipeCategory",data.getItemName());
                startActivity(intent);
            }
        }));

        SearchView searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(SearchActivity.this, RecipeCategoryActivity.class);
                intent.putExtra("recipeCategory",query);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private ArrayList<MainMenuItem> getCuisineList(){
        ArrayList<MainMenuItem> mainMenuList = new ArrayList<>();
        mainMenuList.add(new MainMenuItem("American", R.drawable.american));
        mainMenuList.add(new MainMenuItem("Asian", R.drawable.asian));
        mainMenuList.add(new MainMenuItem("British", R.drawable.british));
        mainMenuList.add(new MainMenuItem("Caribbean", R.drawable.caribbean));
        mainMenuList.add(new MainMenuItem("Central Europe", R.drawable.europe_central));
        mainMenuList.add(new MainMenuItem("Chinese", R.drawable.chinese));
        mainMenuList.add(new MainMenuItem("Eastern Europe", R.drawable.europe_eastern));
        mainMenuList.add(new MainMenuItem("French", R.drawable.french));
        mainMenuList.add(new MainMenuItem("Indian", R.drawable.indian));
        mainMenuList.add(new MainMenuItem("Italian", R.drawable.italian));
        mainMenuList.add(new MainMenuItem("Japanese", R.drawable.japanese));
        mainMenuList.add(new MainMenuItem("Kosher", R.drawable.kosher));
        mainMenuList.add(new MainMenuItem("Mediterranean", R.drawable.mediterranean));
        mainMenuList.add(new MainMenuItem("Mexican", R.drawable.mexican));
        mainMenuList.add(new MainMenuItem("Middle Eastern", R.drawable.middle_eastern));
        mainMenuList.add(new MainMenuItem("Nordic", R.drawable.nordic));
        return mainMenuList;
    }

    private ArrayList<MainMenuItem> getMealList(){
        ArrayList<MainMenuItem> mainMenuList = new ArrayList<>();
        mainMenuList.add(new MainMenuItem("Breakfast", R.drawable.breakfast));
        mainMenuList.add(new MainMenuItem("Dinner", R.drawable.dinner));
        mainMenuList.add(new MainMenuItem("Lunch", R.drawable.lunch));
        mainMenuList.add(new MainMenuItem("Snack", R.drawable.snack));
        mainMenuList.add(new MainMenuItem("Teatime", R.drawable.teatime));
        return mainMenuList;
    }

}
