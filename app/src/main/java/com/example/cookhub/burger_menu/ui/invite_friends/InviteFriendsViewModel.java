package com.example.cookhub.burger_menu.ui.invite_friends;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InviteFriendsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InviteFriendsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Invite Friends fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}