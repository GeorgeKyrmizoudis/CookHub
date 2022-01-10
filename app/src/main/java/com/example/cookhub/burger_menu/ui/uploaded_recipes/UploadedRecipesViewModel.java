package com.example.cookhub.burger_menu.ui.uploaded_recipes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UploadedRecipesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UploadedRecipesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Uploaded Recipes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}