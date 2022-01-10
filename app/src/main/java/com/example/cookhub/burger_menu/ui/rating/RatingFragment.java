package com.example.cookhub.burger_menu.ui.rating;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cookhub.R;
import com.example.cookhub.burger_menu.ui.favorites.FavoritesViewModel;

public class RatingFragment extends Fragment {

    private RatingViewModel ratingViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ratingViewModel =
                new ViewModelProvider(this).get(RatingViewModel.class);


        View root = inflater.inflate(R.layout.fragment_ratingbar, container, false);

        final TextView textView = root.findViewById(R.id.textView2);
        ratingViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}