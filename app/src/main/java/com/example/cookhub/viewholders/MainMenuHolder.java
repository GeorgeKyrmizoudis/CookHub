package com.example.cookhub.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookhub.R;
import com.example.cookhub.adapters.MainMenuAdapter;
import com.example.cookhub.models.MainMenuItem;

public class MainMenuHolder extends RecyclerView.ViewHolder {


    private MainMenuAdapter.OnItemClickListener listener;

    public MainMenuHolder(@NonNull View itemView, MainMenuAdapter.OnItemClickListener listener)
    {
        super(itemView);
        this.listener = listener;
    }
    public void bind(MainMenuItem data){
        TextView textView = itemView.findViewById(R.id.recipe_category);
        textView.setText(data.getItemName());

        ImageView imageView = itemView.findViewById(R.id.recipe_image);
        imageView.setImageResource(data.getItemSrcId());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v, data);
            }
        });
    }

}
