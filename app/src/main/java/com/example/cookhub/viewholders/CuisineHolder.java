package com.example.cookhub.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookhub.R;
import com.example.cookhub.adapters.CuisineAdapter;
import com.example.cookhub.models.MainMenuItem;

public class CuisineHolder extends RecyclerView.ViewHolder{

    private CuisineAdapter.OnItemClickListener listener;

    public CuisineHolder(@NonNull View itemView, CuisineAdapter.OnItemClickListener listener)
    {
        super(itemView);
        this.listener = listener;
    }
    public void bind(MainMenuItem data){
        TextView textView = itemView.findViewById(R.id.cuisine_text);
        textView.setText(data.getItemName());

        ImageView imageView = itemView.findViewById(R.id.cuisine_image);
        imageView.setImageResource(data.getItemSrcId());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v, data);
            }
        });
    }
}}
