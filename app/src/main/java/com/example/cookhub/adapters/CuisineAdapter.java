package com.example.cookhub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookhub.R;
import com.example.cookhub.activities.SearchActivity;
import com.example.cookhub.models.MainMenuItem;
import com.example.cookhub.viewholders.CuisineHolder;

import java.util.ArrayList;

public class CuisineAdapter extends RecyclerView.Adapter<CuisineHolder>{

    public interface OnItemClickListener{
        void  onClick(View v, MainMenuItem data);
    }

    private ArrayList<MainMenuItem> arrayData;
    private Context context;
    private CuisineAdapter.OnItemClickListener listener;

    public CuisineAdapter(ArrayList<MainMenuItem> arrayData, Context context, CuisineAdapter.OnItemClickListener listener){
        this.arrayData = arrayData;
        this.context = context;
        this.listener = listener;
    }


    @NonNull
    @Override
    public CuisineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.holder_cuisines, parent, false);
        return new CuisineHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CuisineHolder holder, int position) {
        MainMenuItem data = arrayData.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }

}
