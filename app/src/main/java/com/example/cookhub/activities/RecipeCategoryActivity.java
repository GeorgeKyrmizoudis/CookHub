package com.example.cookhub.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cookhub.R;
import com.example.cookhub.adapters.RecipeCategoryAdapter;
import com.example.cookhub.pojo.Hit;
import com.example.cookhub.pojo.JsonResponse;
import com.example.cookhub.pojo.Recipe;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

public class RecipeCategoryActivity extends AppCompatActivity {


    private RequestQueue queue;
    private Gson gson;
    JsonResponse jsonResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_category);

        queue = Volley.newRequestQueue(this);
        gson = new Gson();
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        String category = getIntent().getExtras().getString("recipeCategory");
        TextView activityTitle = findViewById(R.id.recipe_category_name);
        activityTitle.setText(category);
        ImageView backBtn = findViewById(R.id.back_button);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_recipes_category);

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

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String url = "https://api.edamam.com/api/recipes/v2?type=public&q=" + category + "&app_id=9171d28d&app_key=1aa7612b28484e2873caeedbbadcde14";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Log.d("TAG",response);
                jsonResponse = gson.fromJson(response, JsonResponse.class);
                recyclerView.setAdapter(new RecipeCategoryAdapter(getRecipesList(), RecipeCategoryActivity.this, new RecipeCategoryAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(View v, Recipe data) {
                        Intent intent = new Intent(RecipeCategoryActivity.this, RecipeDetailsActivity.class);
                        intent.putExtra("recipe", data);
                        startActivity(intent);
                    }
                }));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.e("TAG", error.getMessage());
            }
        });
        queue.add(stringRequest);

    }

    private ArrayList<Recipe> getRecipesList(){
        ArrayList<Recipe> recipesList = new ArrayList<Recipe>();
        for(Hit hit: jsonResponse.getHits()){
            recipesList.add(hit.getRecipe());
        }
        return recipesList;
    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}
