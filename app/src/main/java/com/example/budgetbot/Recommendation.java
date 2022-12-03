package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Recommendation extends AppCompatActivity {

    private Button search;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        int budget = (intent.getIntExtra("budget",0));
        search= (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });


        ImageButton cartButton = (ImageButton)findViewById(R.id.imageButton);
        Intent cartIntent = new Intent(this, Cart.class);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartIntent.putExtra("budget", budget);

                startActivity(cartIntent);
            }
        });

    }




    private void openActivity2() {
        Intent intent = new Intent(this, SearchRecommendation.class);
        startActivity(intent);
    }


}