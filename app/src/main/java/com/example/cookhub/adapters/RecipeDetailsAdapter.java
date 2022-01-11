package com.example.cookhub.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.cookhub.R;
import com.example.cookhub.viewholders.RecipeDetailsHolder;

import java.util.List;

public class RecipeDetailsAdapter extends RecyclerView.Adapter<RecipeDetailsHolder> {

    private List<String> arrayData;
    private Context context;

    public RecipeDetailsAdapter(List<String> arrayData, Context context){
        this.arrayData = arrayData;
        this.context = context;
    }

    @NonNull
    @Override
    public RecipeDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.holder_ingredients, parent, false);
        return new RecipeDetailsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeDetailsHolder holder, int position) {
        String data = arrayData.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }
}