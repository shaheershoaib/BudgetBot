package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button backButtonLogin = (Button)findViewById(R.id.back_button_login);
        Intent backButtonLoginIntent = new Intent(this, MainActivity.class);


        backButtonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(backButtonLoginIntent);

            } });
    }
}