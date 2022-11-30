package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logo = (ImageView)findViewById(R.id.logo);
        logo.setImageResource(R.drawable.logo);

        int width = 700;
        int height = 700;
        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
        logo.setLayoutParams(parms);



        Button loginButton = (Button) findViewById(R.id.login_button);
        Button signupButton = (Button)findViewById(R.id.signup_button);




        Intent signupIntent = new Intent(this, Signup.class);


        signupButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(signupIntent);

            } });

        Intent loginIntent = new Intent(this, Login.class);


        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(loginIntent);

            } });









    }
}