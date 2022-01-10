package com.example.cookhub.activities;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.cookhub.R;
import com.example.cookhub.burger_menu.MainMenuActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class ToSignUpActivity extends BaseActivity {

    private EditText userName, emailAddress, userPassword, retypePassword;
    private FirebaseAuth firebaseAuth;


    @Override
    public int getLayoutId() {

        return R.layout.activity_to_sign_up;
    }

    @Override
    public void useUIElements() {


        ImageView imageView = findViewById(R.id.signup_return_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //TextView textView = findViewById(R.id.signup_title);
        userName = findViewById(R.id.signup_username_value);
        userPassword = findViewById(R.id.signup_enter_password_value);
        emailAddress = findViewById(R.id.signup_email_value);
        retypePassword = findViewById(R.id.signup_re_password_value);

        firebaseAuth = FirebaseAuth.getInstance();
        Button btnSignUp = findViewById(R.id.signup_button);
        Button btnSignIn = findViewById(R.id.signup_already_registered);
        Button btnGuest = findViewById(R.id.signup_guest_enter);

        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isFinishing() || isDestroyed()) {
                    return;
                }
                if (validate()) {
                    String user_email = emailAddress.getText().toString();
                    String user_password = userPassword.getText().toString();
                    Log.d(user_email, user_password);


                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ToSignUpActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ToSignUpActivity.this, ToSignInActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(ToSignUpActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToSignUpActivity.this, ToSignInActivity.class);
                startActivity(intent);
            }
        });

        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToSignUpActivity.this, "Entering as guest", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ToSignUpActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void startOperations() {

    }

    @Override
    public void stopOperations() {

    }

    @Override
    public void onBackPressed() {

        Toast.makeText(ToSignUpActivity.this, "You pressed the back button!!!", Toast.LENGTH_LONG).show();
        this.finish();
    }

    public boolean validate() {
        boolean result = false;

        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = emailAddress.getText().toString();
        String rPassword = retypePassword.getText().toString();

        if (name.isEmpty() || password.isEmpty() || email.isEmpty() || rPassword.isEmpty()) {
            Toast.makeText(this, "Please enter valid information", Toast.LENGTH_SHORT).show();
        } else {
            if (password.length() < 10 || rPassword.length() < 10) {
                Toast.makeText(ToSignUpActivity.this, "Please, enter a password with at least 10 characters", Toast.LENGTH_LONG).show();
            } else {
                if (!password.equals(rPassword)) {
                    Toast.makeText(ToSignUpActivity.this, "You have not retyped your password correctly", Toast.LENGTH_SHORT).show();
                } else {
                    result = true;
                }
            }
        }
        return result;
    }


}
