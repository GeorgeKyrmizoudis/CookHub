package com.example.cookhub.forgot;



import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.cookhub.BaseActivity;
import com.example.cookhub.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_forgot_password;
    }

    @Override
    public void useUIElements() {
        TextView textView = findViewById(R.id.title_explain);
        EditText forgotEmail = findViewById(R.id.forgot_email_value);
        Button okBtn = findViewById(R.id.ok_button);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().sendPasswordResetEmail(forgotEmail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d("TAG", "Email sent.");
                                }
                            }
                        });

                Snackbar.make(v, "Thank you! We have sent you a new code to your email address",Snackbar.LENGTH_SHORT).show();
                finishActivity(892398723);
            }
        });
        okBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Snackbar.make(v,"You have already clicked the OK button!", Snackbar.LENGTH_LONG).show();
                return false;
            }
        });


    }

    @Override
    public void startOperations() {

    }

    @Override
    public void stopOperations() {

    }

}