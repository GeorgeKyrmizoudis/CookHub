package com.example.cookhub;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    abstract public int getLayoutId();

    abstract public void useUIElements();

    abstract public void startOperations();

    abstract public void stopOperations();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        useUIElements();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startOperations();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        stopOperations();
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}

