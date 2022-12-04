package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class Checkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
    }
    public void goBackToAddress(View view){
        Intent intent = new Intent(this, SetAddress.class);
        startActivity(intent);
    }

    public void goToConfirmation(View view){
        TextView cardNumTxt = findViewById(R.id.cardNum);
        TextView expiryDateTxt = findViewById(R.id.expiryDate);
        TextView cvvTxt = findViewById(R.id.securityNum);

        RadioButton grpApple = findViewById(R.id.apple_radio);
        RadioButton grpCredit = findViewById(R.id.credit_radio);
        RadioButton grpGoogle = findViewById(R.id.google_radio);

        if(!grpApple.isChecked() && !grpGoogle.isChecked() && !grpCredit.isChecked()){
            Toast.makeText(this, "Please select one of the payment options", Toast.LENGTH_SHORT).show();

        }
       else if(cardNumTxt.getText().toString().trim()==""){
            Toast.makeText(this, "Please provide your credit card number", Toast.LENGTH_SHORT).show();
        } else if(cardNumTxt.getText().toString().length()!=16){
            Toast.makeText(this, "Please make sure that you enter 16 digits for your credit card number", Toast.LENGTH_SHORT).show();
        } else if(expiryDateTxt.getText().toString().trim()==""){
            Toast.makeText(this, "Please provide the expiry date of your credit card", Toast.LENGTH_SHORT).show();
        }
        else if(expiryDateTxt.getText().toString().length()!=4){
            Toast.makeText(this, "Please enter expiry date of your card", Toast.LENGTH_SHORT).show();
        } else if(!(expiryDateTxt.getText().toString().substring(0, 2).equals("01") ||
                expiryDateTxt.getText().toString().substring(0, 2).equals("02") ||
                expiryDateTxt.getText().toString().substring(0, 2).equals("03") ||
                expiryDateTxt.getText().toString().substring(0, 2).equals("04") ||
                expiryDateTxt.getText().toString().substring(0, 2).equals("05") ||
                expiryDateTxt.getText().toString().substring(0, 2).equals("06") ||
                expiryDateTxt.getText().toString().substring(0, 2).equals("07") ||
                expiryDateTxt.getText().toString().substring(0, 2).equals("08") ||
                expiryDateTxt.getText().toString().substring(0, 2).equals("09") ||
                expiryDateTxt.getText().toString().substring(0, 2).equals("10") ||
                expiryDateTxt.getText().toString().substring(0, 2).equals("11") ||
                expiryDateTxt.getText().toString().substring(0, 2).equals("12"))){
            Toast.makeText(this, "Please make sure that the expiry date is of correct format", Toast.LENGTH_SHORT).show();}
        else if(Integer.parseInt(expiryDateTxt.getText().toString().substring(2, 4))<22){

            Toast.makeText(this, "Your card is expired", Toast.LENGTH_SHORT).show();
        }
        else if(cvvTxt.getText().toString().trim()==""){

            Toast.makeText(this, "Please enter CCV/CVV of your card", Toast.LENGTH_SHORT).show();
        }else if(cvvTxt.getText().toString().length()!=3){
            Toast.makeText(this, "Please make sure that the your cvv/ccv number is of correct format", Toast.LENGTH_SHORT).show();
        }
        else {

            Intent intent = new Intent(this, OrderDone.class);
            startActivity(intent);
        }
    }
}