package com.example.cookhub.burger_menu.ui.invite_friends;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.example.cookhub.R;
import com.example.cookhub.activities.BaseActivity;


public class InviteFriendsActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_invite_friends;
    }

    @Override
    public void useUIElements() {
        Button button = findViewById(R.id.invite_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Please consider checking out Cookhub, our wonderful recipe app! Soon on PlayStore!");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
        };

    });
    }

    @Override
    public void startOperations() {

    }

    @Override
    public void stopOperations() {

    }
}