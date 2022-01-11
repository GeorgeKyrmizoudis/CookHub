package com.example.cookhub.burger_menu.ui.logout;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cookhub.BaseActivity;
import com.example.cookhub.R;
import com.example.cookhub.ToSignInActivity;
import com.google.firebase.auth.FirebaseAuth;

public class SignOutActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.fragment_logout;
    }

    @Override
    public void useUIElements() {

        TextView textView = findViewById(R.id.logout_message);
        Button SignOutButton = findViewById(R.id.signout_button);

        textView.setText("Press the SIGN OUT button to sign out");
        SignOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Are you sure?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        signOut();
                        // Perform Action & Dismiss dialog
                        dialog.dismiss();
                    }
                }).setNegativeButton("No", dialogClickListener).show();

            }

        });

    }

    @Override
    public void startOperations() {

    }

    @Override
    public void stopOperations() {

    }

    public void signOut() {
        // [START auth_sign_out]
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(SignOutActivity.this, "Signing out...", Toast.LENGTH_SHORT).show();
        finish();
        startActivity(new Intent(SignOutActivity.this, ToSignInActivity.class));
        // [END auth_sign_out]
    }
}