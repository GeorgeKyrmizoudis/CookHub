package com.example.cookhub.burger_menu.ui.personal_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.cookhub.BaseActivity;
import com.example.cookhub.R;

public class PersonalDataActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal_data;
    }

    @Override
    public void useUIElements() {

        TextView textView = findViewById(R.id.text_personal_data);
        textView.setText("Here you can find your personal preferences, with respect to your liking!");
    }

    @Override
    public void startOperations() {

    }

    @Override
    public void stopOperations() {

    }


}