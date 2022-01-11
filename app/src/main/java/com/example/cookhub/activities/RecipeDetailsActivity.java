package com.example.cookhub.activities;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.cookhub.R;
import com.example.cookhub.adapters.RecipeDetailsAdapter;
import com.example.cookhub.pojo.Recipe;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

public class RecipeDetailsActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.recipe_details;
    }

    @Override
    public void useUIElements() {
        ImageView imageView = findViewById(R.id.recipe_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        ToggleButton imageButton = findViewById(R.id.recipe_empty_like);
        //boolean disliked_liked = false;
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("APP","Liked recipe");
                Toast.makeText(RecipeDetailsActivity.this, "Recipe liked!!!", Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton imagebtn = findViewById(R.id.recipe_share);
        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Please consider checking out Cookhub, our wonderful recipe app! Soon on PlayStore! https://www.youtube.com/c/GreekParanoia");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
    }
    @Override
    public void startOperations() {

    }

    @Override
    public void stopOperations() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_details);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Recipe recipe_data = getIntent().getExtras().getParcelable("recipe");

        RecyclerView recyclerView = findViewById(R.id.recipe_ingredients_list);
        recyclerView.setAdapter(new RecipeDetailsAdapter(getDataList(), this));


        ImageView imageView = findViewById(R.id.recipe_img);
        /*Log.d("IMAGE", "bind: "+ );*/
        Picasso.with(imageView.getContext()).load(recipe_data.getImage()).error(R.mipmap.ic_launcher).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                Log.d("TAG", "onSuccess");
            }

            @Override
            public void onError() {
            }
        });
    }

    private List<String> getDataList(){
        String[] ingredients = {"2 tbsp. extra-virgin olive oil","4 (6-oz.) filet mignon","Kosher salt","Freshly ground black pepper","4 tbsp. butter","1 tbsp. roughly chopped rosemary"};
        List<String> list = Arrays.asList(ingredients);
        return list;
    }
  /*  private ArrayList<Recipe> getRecipesList() {
        ArrayList<Recipe> recipesList = new ArrayList<Recipe>();
        for (Hit hit : jsonResponse.getHits()) {
            recipesList.add(hit.getRecipe());
        }
        return recipesList;
    }*/
}
