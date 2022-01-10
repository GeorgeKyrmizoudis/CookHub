package com.example.cookhub;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SignedInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getBaseContext().getResources().getString(R.string.app_name);

        FirebaseAuth.getInstance();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Button button = findViewById(R.id.logout_btn);
       button.setOnClickListener(new View.OnClickListener() {
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
    protected void onResume() {
        super.onResume();

        //String name = getIntent().getExtras().getString("name");
        //Log.d("APP", name);
    }

    private boolean secondTap = false;

    @Override
    public void onBackPressed() {
        Toast.makeText(SignedInActivity.this, "Press again to exit", Toast.LENGTH_SHORT).show();

        if (!secondTap) {
            super.onBackPressed();
        } else {
            secondTap = true;
        }
    }

    public void signOut() {
        // [START auth_sign_out]
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(SignedInActivity.this, "Signing out...", Toast.LENGTH_SHORT).show();
        finish();
        startActivity(new Intent(SignedInActivity.this, ToSignInActivity.class));
        // [END auth_sign_out]
    }
}
