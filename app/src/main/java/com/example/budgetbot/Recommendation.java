package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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
        TextView budgetRem = (TextView) findViewById(R.id.textView2);
        budgetRem.setText("$"+String.valueOf(budget));
        search= (Button) findViewById(R.id.search);
        Intent intent2 = new Intent(this, SearchRecommendation.class);
        intent2.putExtra("budget", budget);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
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

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }






}