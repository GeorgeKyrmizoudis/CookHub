package com.example.cookhub.activities;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
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

    String check;
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
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Check this out!!! "+check);
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
        recyclerView.setAdapter(new RecipeDetailsAdapter(recipe_data.ingredientLines, this));

        check=recipe_data.url;

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
        TextView recipe_txt = findViewById(R.id.recipe_name);
        recipe_txt.setText(recipe_data.label);

        TextView nutrinfo = findViewById(R.id.recipe_nutrition_info);
        nutrinfo.setText("Nutrition Information:\n" + recipe_data.calories + " Calories\n\n" + "Cautions: " + recipe_data.cautions);

        TextView recipe_instr = findViewById(R.id.recipe_instructions);
        recipe_instr.setText("For instructions go to: " + recipe_data.url);
    }

}
