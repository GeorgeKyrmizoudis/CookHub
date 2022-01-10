package com.example.cookhub.burger_menu.ui.personal_data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PersonalDataViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PersonalDataViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Personal Data fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}