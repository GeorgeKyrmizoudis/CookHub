package com.example.cookhub.viewholders;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookhub.R;


public class RecipeDetailsHolder extends RecyclerView.ViewHolder {

    public RecipeDetailsHolder(@NonNull View itemView){
        super(itemView);
    }

    public void bind(String data){
        TextView textView = itemView.findViewById(R.id.holder_list);
        textView.setText(data);
    }
}
