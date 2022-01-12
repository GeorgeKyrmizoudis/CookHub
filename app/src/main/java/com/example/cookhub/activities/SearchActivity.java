package com.example.cookhub.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.example.cookhub.R;
import com.example.cookhub.adapters.CuisineAdapter;
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
        cuisineRecycler.setAdapter(new CuisineAdapter(getDataList(), this, new CuisineAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, MainMenuItem data) {

            }
        }));

        RecyclerView dishTypeRecycler = findViewById(R.id.recycler_view_dish_type);
        dishTypeRecycler.setAdapter(new CuisineAdapter(getDataList(), this, new CuisineAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, MainMenuItem data) {

            }
        }));
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

}