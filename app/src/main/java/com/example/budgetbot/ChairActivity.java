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

public class ChairActivity extends AppCompatActivity {
    Toast toast;
    @SuppressLint("RestrictedApi")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chair);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        ImageButton cartButton = (ImageButton)findViewById(R.id.imageButton);
        Intent cartIntent = new Intent(this, Cart.class);

        Intent intent = getIntent();
        int budget = (intent.getIntExtra("budget",0));
        TextView budgetRem = (TextView) findViewById(R.id.textView2);
        budgetRem.setText("$"+String.valueOf(budget));


        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(cartIntent);
            }
        });

        Button addIgolfChair = (Button)findViewById(R.id.button2);
        addIgolfChair.setText("ADD");
        addIgolfChair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addIgolfChair.getText().toString().equals("ADD")) {
                    if(toast!=null)
                        toast.cancel();
                    toast = Toast.makeText(getApplicationContext(), "Added Igolf Chair To Cart", Toast.LENGTH_SHORT);
                    toast.show();
                    addIgolfChair.setText("REMOVE");
                }

                else{
                    if(toast!=null)
                        toast.cancel();
                    toast =  Toast.makeText(getApplicationContext(), "Removed Igolf Chair From Cart", Toast.LENGTH_SHORT);
                    toast.show();
                    addIgolfChair.setText("ADD");
                }

            }
        });



        Button addLerhamnChair = (Button)findViewById(R.id.button3);
        addLerhamnChair.setText("ADD");
        addLerhamnChair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addLerhamnChair.getText().toString().equals("ADD")) {
                    if(toast!=null)
                        toast.cancel();
                    toast =  Toast.makeText(getApplicationContext(), "Added Lerhamn Chair To Cart", Toast.LENGTH_SHORT);
                    toast.show();
                    addLerhamnChair.setText("REMOVE");
                }

                else{
                    if(toast!=null)
                        toast.cancel();
                    toast = Toast.makeText(getApplicationContext(), "Removed Lerhamn Chair From Cart", Toast.LENGTH_SHORT);
                    toast.show();
                    addLerhamnChair.setText("ADD");
                }
            }});


        Button addSteffanChair = (Button)findViewById(R.id.button4);
        addSteffanChair.setText("ADD");
        addSteffanChair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(addSteffanChair.getText().toString().equals("ADD")) {
                    if(toast!=null)
                        toast.cancel();
                    toast = Toast.makeText(getApplicationContext(), "Added Steffan Chair To Cart", Toast.LENGTH_SHORT);
                    toast.show();
                    addSteffanChair.setText("REMOVE");
                }

                else{
                    if(toast!=null)
                        toast.cancel();
                    toast = Toast.makeText(getApplicationContext(), "Removed Steffan Chair From Cart", Toast.LENGTH_SHORT);
                    toast.show();
                    addSteffanChair.setText("ADD");
                }
            }
        });

    }






}