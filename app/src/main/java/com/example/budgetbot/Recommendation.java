package com.example.budgetbot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Recommendation extends AppCompatActivity {

    private Button search;
    Toast toast;

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

        Button addIgolfChair = (Button)findViewById(R.id.button2);
        addIgolfChair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addIgolfChair.getText().toString().equals("Add")) {
                    if(toast!=null)
                        toast.cancel();
                    toast = Toast.makeText(getApplicationContext(), "Added Igolf Chair To Cart", Toast.LENGTH_SHORT);
                    toast.show();
                    addIgolfChair.setText("Remove");
                }

                else{
                    if(toast!=null)
                        toast.cancel();
                   toast =  Toast.makeText(getApplicationContext(), "Removed Igolf Chair From Cart", Toast.LENGTH_SHORT);
                   toast.show();
                    addIgolfChair.setText("Add");
                }

            }
        });



        Button addLerhamnChair = (Button)findViewById(R.id.button3);
        addLerhamnChair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addLerhamnChair.getText().toString().equals("Add")) {
                   if(toast!=null)
                       toast.cancel();
                   toast =  Toast.makeText(getApplicationContext(), "Added Lerhamn Chair To Cart", Toast.LENGTH_SHORT);
                    toast.show();
                    addLerhamnChair.setText("Remove");
                }

                else{
                    if(toast!=null)
                        toast.cancel();
                    toast = Toast.makeText(getApplicationContext(), "Removed Lerhamn Chair From Cart", Toast.LENGTH_SHORT);
                    toast.show();
                    addLerhamnChair.setText("Add");
                }
        }});


        Button addSteffanChair = (Button)findViewById(R.id.button4);
        addSteffanChair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(addSteffanChair.getText().toString().equals("Add")) {
                    if(toast!=null)
                        toast.cancel();
                    toast = Toast.makeText(getApplicationContext(), "Added Steffan Chair To Cart", Toast.LENGTH_SHORT);
                    toast.show();
                    addSteffanChair.setText("Remove");
                }

                else{
                    if(toast!=null)
                        toast.cancel();
                    toast = Toast.makeText(getApplicationContext(), "Removed Steffan Chair From Cart", Toast.LENGTH_SHORT);
                    toast.show();
                    addSteffanChair.setText("Add");
                }
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }




}


