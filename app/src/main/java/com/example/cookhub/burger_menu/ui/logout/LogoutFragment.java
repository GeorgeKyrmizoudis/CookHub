package com.example.cookhub.burger_menu.ui.logout;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cookhub.R;


public class LogoutFragment extends Fragment{

    private com.example.cookhub.burger_menu.ui.logout.LogoutViewModel logoutViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        logoutViewModel =
                new ViewModelProvider(this).get(LogoutViewModel.class);


        View root = inflater.inflate(R.layout.fragment_logout, container, false);

        final TextView textView = root.findViewById(R.id.logout_message);
        Button button = root.findViewById(R.id.signout_button);
        logoutViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }

            private void onBackPressed() {
               View root =  inflater.inflate(R.layout.sign_in, container,false);
            }
        });


        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}