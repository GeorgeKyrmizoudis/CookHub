package com.example.cookhub.burger_menu.ui.personal_data;

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


public class PersonalDataFragment extends Fragment {

    private PersonalDataViewModel personalDataViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        personalDataViewModel =
                new ViewModelProvider(this).get(PersonalDataViewModel.class);


        View root = inflater.inflate(R.layout.fragment_personal_data, container, false);

        final TextView textView = root.findViewById(R.id.text_personal_data);
        personalDataViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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