package com.example.cookhub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookhub.R;
import com.example.cookhub.models.MainMenuItem;
import com.example.cookhub.viewholders.MainMenuHolder;

import java.util.ArrayList;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuHolder> {

    public interface OnItemClickListener{
        void  onClick(View v, MainMenuItem data);
    }

    private ArrayList<MainMenuItem> arrayData;
    private Context context;
    private OnItemClickListener listener;

    public MainMenuAdapter(ArrayList<MainMenuItem> arrayData, Context context, OnItemClickListener listener){
        this.arrayData = arrayData;
        this.context = context;
        this.listener = listener;
    }


    @NonNull
    @Override
    public MainMenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.holder_item_category, parent, false);
        return new MainMenuHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MainMenuHolder holder, int position) {
        MainMenuItem data = arrayData.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }
}
