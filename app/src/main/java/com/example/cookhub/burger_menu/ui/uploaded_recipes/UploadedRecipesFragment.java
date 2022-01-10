package com.example.cookhub.burger_menu.ui.uploaded_recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cookhub.R;


public class UploadedRecipesFragment extends Fragment {

    private UploadedRecipesViewModel uploadedRecipesViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        uploadedRecipesViewModel =
                new ViewModelProvider(this).get(UploadedRecipesViewModel.class);


        View root = inflater.inflate(R.layout.fragment_uploaded, container, false);

        final TextView textView = root.findViewById(R.id.text_uploaded);
        uploadedRecipesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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