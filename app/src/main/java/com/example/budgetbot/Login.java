package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button backButtonLogin = (Button)findViewById(R.id.back_button_login);
        Intent backButtonLoginIntent = new Intent(this, HomeScreen.class);
        Intent shopIntentFromLogin = new Intent(this, Shop.class);


        backButtonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(backButtonLoginIntent);

            } });

        EditText emailLogin = (EditText) findViewById(R.id.email_login);
        EditText passwordLogin = (EditText) findViewById(R.id.password_login);

        Button submitLogin = (Button)findViewById(R.id.submit_login);

        submitLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String emailLoginValue = emailLogin.getText().toString();
                String passwordLoginValue = passwordLogin.getText().toString();


                if(!isValidEmail(emailLoginValue))
                    Toast.makeText(getApplicationContext(),"Please enter a valid email",Toast.LENGTH_SHORT).show();
                else if(passwordLoginValue.equals(""))
                    Toast.makeText(getApplicationContext(), "Please enter a password", Toast.LENGTH_SHORT).show();
                else {

                    String file = "output.txt";
                    String line = "";
                    String data = "";


                    try (FileInputStream fis = openFileInput(file);
                         InputStreamReader isr = new InputStreamReader(fis);
                         BufferedReader br = new BufferedReader(isr);) {
                        while ((line = br.readLine()) != null) {
                            data += line + "\n";

                        }

                        String[] linesInFile = data.split("\\r?\\n");
                        String[] dataFromLine;
                        String emailFile;
                        String passwordFile;
                        boolean found = false;

                        for(int counter=0; counter<linesInFile.length; counter++) {
                            dataFromLine = linesInFile[counter].split(",");
                            emailFile = dataFromLine[0];
                            passwordFile = dataFromLine[1];
                            if(emailFile.equals(emailLoginValue) && passwordFile.equals(passwordLoginValue)){
                                found = true;
                                break;
                            }

                        }

                        if(!found)
                            Toast.makeText(getApplicationContext(), "Email or password is incorrect. Please try again", Toast.LENGTH_SHORT).show();
                        else
                           startActivity(shopIntentFromLogin);


                    }  catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Email or password is incorrect. Please try again", Toast.LENGTH_SHORT).show();
                    }
                }

                } });


    }

    public boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;

        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}