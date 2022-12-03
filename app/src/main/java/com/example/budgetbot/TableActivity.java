package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TableActivity extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        ImageButton cartButton = (ImageButton)findViewById(R.id.imageButton);
        Intent cartIntent = new Intent(this, Cart.class);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(cartIntent);
            }
        });
    }
}