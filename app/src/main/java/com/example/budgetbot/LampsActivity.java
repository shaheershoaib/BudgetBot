package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LampsActivity extends AppCompatActivity {
    Toast toast;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamps);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        ImageButton cartButton = (ImageButton) findViewById(R.id.imageButton);
        Intent cartIntent = new Intent(this, Cart.class);
        Intent intent = getIntent();
        int budget = (intent.getIntExtra("budget", 0));
        TextView budgetRem = (TextView) findViewById(R.id.textView2);
        budgetRem.setText("$" + String.valueOf(budget));

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(cartIntent);
            }
        });


        Button addAmazonLamp = (Button)findViewById(R.id.button2);
        addAmazonLamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addAmazonLamp.getText().toString().equals("Add")) {
                    if(toast!=null)
                        toast.cancel();
                    toast =  Toast.makeText(getApplicationContext(), "Added Amazon Lamp To Cart", Toast.LENGTH_SHORT);
                    toast.show();
                    addAmazonLamp.setText("Remove");
                }

                else{
                    if(toast!=null)
                        toast.cancel();
                    toast = Toast.makeText(getApplicationContext(), "Removed Amazon Lamp From Cart", Toast.LENGTH_SHORT);
                    toast.show();
                    addAmazonLamp.setText("Add");
                }
            }});


        Button addAstridLamp = (Button)findViewById(R.id.button3);
        addAstridLamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(addAstridLamp.getText().toString().equals("Add")) {
                    if(toast!=null)
                        toast.cancel();
                    toast = Toast.makeText(getApplicationContext(), "Added Astrid Lamp To Cart", Toast.LENGTH_SHORT);
                    toast.show();
                    addAstridLamp.setText("Remove");
                }

                else{
                    if(toast!=null)
                        toast.cancel();
                    toast = Toast.makeText(getApplicationContext(), "Removed Astrid Lamp From Cart", Toast.LENGTH_SHORT);
                    toast.show();
                    addAstridLamp.setText("Add");
                }
            }
        });

        Button addSnakeLamp = (Button)findViewById(R.id.button4);
        addSnakeLamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(addSnakeLamp.getText().toString().equals("Add")) {
                    if(toast!=null)
                        toast.cancel();
                    toast = Toast.makeText(getApplicationContext(), "Added Snake Lamp To Cart", Toast.LENGTH_SHORT);
                    toast.show();
                   addSnakeLamp.setText("Remove");
                }

                else{
                    if(toast!=null)
                        toast.cancel();
                    toast = Toast.makeText(getApplicationContext(), "Removed Snake Lamp From Cart", Toast.LENGTH_SHORT);
                    toast.show();
                   addSnakeLamp.setText("Add");
                }
            }
        });



    }



    }