package com.example.budgetbot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SetAddress extends AppCompatActivity {
    //static final String STATE_USER = "user";
    //String e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_set);

       /* if(savedInstanceState!=null){
            e = savedInstanceState.getString("country");
            TextView txt = findViewById(R.id.user_country);
            txt.setText(e);
            Toast.makeText(this, "city info" + e, Toast.LENGTH_SHORT).show();
        }*/



    }

    public void goBack(View view){
        Intent intent = new Intent(this, Cart.class);
        startActivity(intent);
    }

    public void goToCheckout(View view){
        TextView countryTxt = findViewById(R.id.user_country);
        TextView cityTxt = findViewById(R.id.user_city);
        TextView zipTxt = findViewById(R.id.user_zipcode);
        TextView streetTxt = findViewById(R.id.user_street);
        if(countryTxt.getText().toString().trim().equals("")){
            Toast.makeText(this, "Please provide your country name", Toast.LENGTH_SHORT).show();
        }
        else if(cityTxt.getText().toString().trim().equals("")){
            Toast.makeText(this, "Please provide your city name", Toast.LENGTH_SHORT).show();
        }
        else if(zipTxt.getText().toString().trim().equals("")){
            Toast.makeText(this, "Please provide your zip/postal code", Toast.LENGTH_SHORT).show();
        }
        else if(streetTxt.getText().toString().trim().equals("")){
            Toast.makeText(this, "Please provide your street information", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, Checkout.class);
            startActivity(intent);
        }



    }

   // @Override
   /* protected void onSaveInstanceState(@NonNull Bundle outState) {

        String countryTxt = ((TextView)findViewById(R.id.user_country)).getText().toString();
        String cityTxt = ((TextView)findViewById(R.id.user_city)).getText().toString();
        String zipTxt = ((TextView)findViewById(R.id.user_zipcode)).getText().toString();
        String streetTxt = ((TextView)findViewById(R.id.user_street)).getText().toString();
        outState.putString("country", countryTxt);
        outState.putString("city", cityTxt);
        outState.putString("zip", zipTxt);
        outState.putString("street", streetTxt);

        super.onSaveInstanceState(outState);



    }*/

}