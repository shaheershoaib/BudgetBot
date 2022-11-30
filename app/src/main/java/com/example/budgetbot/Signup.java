package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        Button backButtonSignup = (Button)findViewById(R.id.back_button_signup);
        Intent backButtonSignupIntent = new Intent(this, MainActivity.class);



        backButtonSignup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(backButtonSignupIntent);

            } });






        EditText emailSignup = (EditText) findViewById(R.id.email_signup);
        EditText passwordSignup = (EditText) findViewById(R.id.password_signup);
        EditText confirmPasswordSignup = (EditText) findViewById(R.id.confirm_password_signup);

        String emailSignupValue = emailSignup.getText().toString();
        String passwordSignupValue = passwordSignup.getText().toString();
        String confirmPasswordSignupValue = confirmPasswordSignup.getText().toString();


        Button signupSubmit = (Button)findViewById(R.id.submit_signup);

        signupSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!isValidEmail(emailSignupValue))
                    Toast.makeText(getApplicationContext(),"Please enter a valid email",Toast.LENGTH_SHORT).show();


            } });



    }



    public boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;

        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}