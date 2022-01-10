package com.example.cookhub.burger_menu.ui.invite_friends;

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
import com.example.cookhub.burger_menu.ui.notifications.NotificationsViewModel;

public class InviteFriendsFragment extends Fragment {

    private InviteFriendsViewModel inviteFriendsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        inviteFriendsViewModel =
                new ViewModelProvider(this).get(InviteFriendsViewModel.class);


        View root = inflater.inflate(R.layout.fragment_invite_friends, container, false);

        final TextView textView = root.findViewById(R.id.text_invite_friends);
        inviteFriendsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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