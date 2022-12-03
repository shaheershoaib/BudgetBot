package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Signup extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        Button backButtonSignup = (Button)findViewById(R.id.back_button_signup);
        Intent backButtonSignupIntent = new Intent(this, HomeScreen.class);

        Intent shopIntentFromSignup = new Intent(this, Shop.class);


        backButtonSignup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(backButtonSignupIntent);

            } });




        EditText emailSignup = (EditText) findViewById(R.id.email_signup);
        EditText passwordSignup = (EditText) findViewById(R.id.password_signup);
        EditText confirmPasswordSignup = (EditText) findViewById(R.id.confirm_password_signup);


        Button signupSubmit = (Button)findViewById(R.id.submit_signup);

        signupSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                String emailSignupValue = emailSignup.getText().toString().trim();
                String passwordSignupValue = passwordSignup.getText().toString();
                String confirmPasswordSignupValue = confirmPasswordSignup.getText().toString();



                String file = "output.txt";
                String line = "";
                String data = "";
                boolean found = false;


                try (FileInputStream fis = openFileInput(file);
                     InputStreamReader isr = new InputStreamReader(fis);
                     BufferedReader br = new BufferedReader(isr);

                ) {
                    while ((line = br.readLine()) != null) {
                        data += line + "\n";

                    }

                    String[] linesInFile = data.split("\\r?\\n");
                    String[] dataFromLine;
                    String emailFile;

                    for (int counter = 0; counter < linesInFile.length; counter++) {
                        dataFromLine = linesInFile[counter].split(",");
                        emailFile = dataFromLine[0];
                        if (emailFile.equals(emailSignupValue)) {
                            found = true;
                            break;
                        }

                    }

                } catch(IOException e){e.printStackTrace();}

                if(!isValidEmail(emailSignupValue))
                    Toast.makeText(getApplicationContext(),"Please enter a valid email",Toast.LENGTH_SHORT).show();
                else if(found)
                    Toast.makeText(getApplicationContext(), "An account with this email already exists. Please login.", Toast.LENGTH_SHORT).show();
                else if(passwordSignupValue.equals(""))
                    Toast.makeText(getApplicationContext(), "Please enter a password", Toast.LENGTH_SHORT).show();
                else if(confirmPasswordSignupValue.equals(""))
                    Toast.makeText(getApplicationContext(), "Please confirm your password", Toast.LENGTH_SHORT).show();
                else if(!confirmPasswordSignupValue.equals(passwordSignupValue))
                    Toast.makeText(getApplicationContext(), "Please ensure your password confirmation is correct", Toast.LENGTH_SHORT).show();

                else {



                        String fileName = "output.txt";
                        FileOutputStream outputStream;
                        String fileContents = emailSignupValue + ',' + passwordSignupValue + '\n';
                        try {
                            outputStream = openFileOutput(fileName, Context.MODE_APPEND);
                            outputStream.write(fileContents.getBytes());    //FileOutputStream is meant for writing streams of raw bytes.
                            outputStream.close();

                            startActivity(shopIntentFromSignup);
                        } catch (IOException I) {
                            I.printStackTrace();
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