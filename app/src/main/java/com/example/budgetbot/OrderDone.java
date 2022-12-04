package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OrderDone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_done);
    }

    public void goBackToMain(View view){
        Intent intent = new Intent(this, Shop.class);
        startActivity(intent);
    }
}