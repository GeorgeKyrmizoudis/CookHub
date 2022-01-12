package com.example.cookhub.burger_menu.ui.rating;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cookhub.R;

public class RatingActivity extends AppCompatActivity {
    RatingBar ratingBar;
    TextView ratingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_bar);

        ratingBar = findViewById(R.id.ratingBar);
        ratingText = findViewById(R.id.ratingText);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingText.setText("Your Rating: " + rating);
                Toast.makeText(RatingActivity.this, "Thank you for your evaluation!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}