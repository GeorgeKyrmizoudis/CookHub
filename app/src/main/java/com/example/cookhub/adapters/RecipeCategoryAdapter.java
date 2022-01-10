package com.example.cookhub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookhub.R;
import com.example.cookhub.activities.RecipeCategoryActivity;
import com.example.cookhub.pojo.Recipe;
import com.example.cookhub.viewholders.RecipeCategoryHolder;

import java.util.ArrayList;

public class RecipeCategoryAdapter extends RecyclerView.Adapter<RecipeCategoryHolder>{

    public interface OnItemClickListener{
        void  onClick(View v, Recipe data);
    }

    private ArrayList<Recipe> arrayData;
    private Context context;
    private RecipeCategoryAdapter.OnItemClickListener listener;

    public RecipeCategoryAdapter(ArrayList<Recipe> arrayData, Context context, RecipeCategoryAdapter.OnItemClickListener listener){
        this.arrayData = arrayData;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecipeCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.holder_item_recipe, parent, false);
        return new RecipeCategoryHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeCategoryHolder holder, int position) {
        Recipe data = arrayData.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }

}
