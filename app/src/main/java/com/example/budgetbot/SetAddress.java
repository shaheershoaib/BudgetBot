package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SetAddress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_address);
    }

    public void goBack(View view){
        Intent intent = new Intent(this, Cart.class);
        startActivity(intent);
    }

    public void goToCheckout(View view){
        Intent intent = new Intent(this, Checkout.class);
        startActivity(intent);
    }
}