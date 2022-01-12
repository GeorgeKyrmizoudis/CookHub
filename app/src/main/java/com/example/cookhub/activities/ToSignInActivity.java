package com.example.cookhub.activities;



import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.cookhub.R;
import com.example.cookhub.burger_menu.MainMenuActivity;
import com.example.cookhub.forgot.ForgotPasswordActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ToSignInActivity extends BaseActivity {
    private EditText userMail, passWord;
    private FirebaseAuth firebaseAuth;


    @Override
    public int getLayoutId() {

        return R.layout.sign_in;


    }



    @Override
    public void useUIElements() {
        firebaseAuth = FirebaseAuth.getInstance();

//        if(firebaseAuth.getCurrentUser()!= null){
//            finish();
//            startActivity(new Intent(getApplicationContext(), SignedInActivity.class));
//        }

        ImageView imageView = findViewById(R.id.login_back_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        userMail =  findViewById(R.id.login_email_value);
        passWord = findViewById(R.id.login_password_value);
        TextView textView = findViewById(R.id.login_title);
        textView.setText(getString(R.string.app_name));


        Button btnLogin = findViewById(R.id.login_button);
        Button btnForgot = findViewById(R.id.login_forgot_password);
        Button btnGuest = findViewById(R.id.login_guest);
        Button btnSignUp = findViewById(R.id.not_registered);




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isDestroyed() || isFinishing()) {
                    return;
                }

                if (validate()) {
                    firebaseAuth.signInWithEmailAndPassword(userMail.getText().toString().trim(), passWord.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d("TAG", "signInWithEmail:success");
                                Toast.makeText(ToSignInActivity.this, "Authentication successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ToSignInActivity.this, MainActivity.class));
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("TAG", "signInWithEmail:failure", task.getException());
                                Toast.makeText(ToSignInActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

                    Toast.makeText(ToSignInActivity.this, "Waiting to login...", Toast.LENGTH_SHORT).show();
                }
        });

        btnLogin.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Snackbar.make(view, "Sign in button clicked!!!", Snackbar.LENGTH_SHORT).show();
               // Toast.makeText(MainActivity.this, "Button Long clicked!!!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ToSignInActivity.this, "Forgotten password checked!",Toast.LENGTH_SHORT).show();
                Log.d("APP", "forgot button clicked!!!");

                Intent intent = new Intent(ToSignInActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToSignInActivity.this,"Sign up clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ToSignInActivity.this, ToSignUpActivity.class);
                startActivity(intent);
            }
        });

        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Toast.makeText(ToSignInActivity.this, "Guest clicked", Toast.LENGTH_SHORT).show();

                FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                updateUI(currentUser);

                firebaseAuth.signInAnonymously()
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {// Sign in success, update UI with the signed-in user's information
                                    Log.d("TAG", "signInAnonymously:success");
                                    FirebaseUser user = firebaseAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("TAG", "signInAnonymously:failure", task.getException());
                                    Toast.makeText(ToSignInActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }
                            }
                        });
               //Intent intent = new Intent(ToSignInActivity.this, MainMenuActivity.class);
                Intent intent = new Intent(ToSignInActivity.this, MainActivity.class);
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

        Toast.makeText(ToSignInActivity.this, "You pressed the back button!!!", Toast.LENGTH_LONG).show();
        this.finish();
    }


    private boolean validate(){
        boolean result = false;
        String password = passWord.getText().toString();
        String email = userMail.getText().toString();

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(ToSignInActivity.this, "Please enter valid information", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }
        return result;
    }


    private void updateUI(FirebaseUser user){

    }
}