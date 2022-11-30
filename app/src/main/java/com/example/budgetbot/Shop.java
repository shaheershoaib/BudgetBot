package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        ImageView logo = (ImageView)findViewById(R.id.logo_shop);
        logo.setImageResource(R.drawable.logo);

        int width = 700;
        int height = 700;
        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
        logo.setLayoutParams(parms);


        Intent signoutIntent = new Intent(this, HomeScreen.class);

        Button signout = (Button)findViewById(R.id.signout_shop);

        signout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(signoutIntent);

            } });

    }
}