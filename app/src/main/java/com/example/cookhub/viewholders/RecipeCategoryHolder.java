package com.example.cookhub.viewholders;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookhub.R;
import com.example.cookhub.adapters.RecipeCategoryAdapter;
import com.example.cookhub.pojo.Recipe;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class RecipeCategoryHolder extends RecyclerView.ViewHolder {

    private RecipeCategoryAdapter.OnItemClickListener listener;

    public RecipeCategoryHolder(@NonNull View itemView, RecipeCategoryAdapter.OnItemClickListener listener)
    {
        super(itemView);
        this.listener = listener;
    }
    public void bind(Recipe data){

        ImageView imageView = itemView.findViewById(R.id.item_image);
        /*Log.d("IMAGE", "bind: "+ );*/
        Picasso.with(imageView.getContext()).load(data.getImage()).error(R.mipmap.ic_launcher).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                Log.d("TAG", "onSuccess");
            }

            @Override
            public void onError() {
            }
        });

        TextView title = itemView.findViewById(R.id.item_name);
        title.setText(data.getLabel());

        TextView made = itemView.findViewById(R.id.item_description);
        made.setText("by " + data.getSource());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v, data);
            }
        });

        ImageView buttonShare = itemView.findViewById(R.id.btn_share);
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Check this out!!! "+ data.getUrl());
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                v.getContext().startActivity(shareIntent);
            }
        });
    }
}
