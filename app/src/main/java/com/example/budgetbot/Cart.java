package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cart extends AppCompatActivity implements Item_RV_Adapter.AdapterCallback {

    ArrayList<Item_model> itemModel = new ArrayList<>();
    int itemCount = 2;
    public static TextView budget_rem;
    int budget_calc;
    int budget_original;
    int budget_remaining;
    TextView tv;

    private Item_RV_Adapter mMyAdapter;

    @Override
    public void onMethodCallback(String yourValue) {
//        tv = findViewById(R.id.budget_rem);

        if(Integer.parseInt(yourValue)>0){
            budget_remaining -= Integer.valueOf(yourValue);
        }
        else if(Integer.parseInt(yourValue)<0) {
            budget_remaining -= Integer.valueOf(yourValue);
        }

        if(budget_remaining<0)
            Toast.makeText(getApplicationContext(), "You have used up all your budget", Toast.LENGTH_LONG).show();


        tv.setText("Budget remaining $:" + budget_remaining);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_layout);

        Intent intent = getIntent();
        budget_original = intent.getIntExtra("budget",0);
        Toast.makeText(getApplicationContext(), "Ybdgt" + budget_original, Toast.LENGTH_LONG).show();


        budget_remaining = budget_original;

        RecyclerView recyclerView = findViewById(R.id.mRecycleView);
        tv = findViewById(R.id.budget_rem);





//      below will be done using fis
        String[] itemNames = getResources().getStringArray(R.array.items);
        int [] itemPrices = getResources().getIntArray(R.array.cart_prices);
        int [] itemAmount = getResources().getIntArray(R.array.amounts);

        for(int i =0; i<itemNames.length; i++) {
            itemModel.add(new Item_model(itemNames[i], itemPrices[i], itemAmount[i]));
        }

//        setupItemModel(); <-- not needed; can build in on-create, can use fis here

        Button goBackFromCart = (Button)findViewById(R.id.back_button);
        goBackFromCart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();

            } });




        Item_RV_Adapter adapter = new Item_RV_Adapter(this,itemModel);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        String file = "data.txt";
//        String line = "";
//        String data = "";
//
//        try {
//            FileInputStream fis = openFileInput(file);  //A FileInputStream obtains input bytes from a file in a file system
//            InputStreamReader isr = new InputStreamReader(fis); //An InputStreamReader is a bridge from byte streams to character streams
//            BufferedReader br = new BufferedReader(isr);    //Reads text from a character-input stream,
//
//            while((line = br.readLine()) != null) {
//
//            }
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }

    //TO DO: try and run this in on-create, should work so that fis will be in on-create
    //else just write fis in here then
//    private void setupItemModel(){
//        String[] itemNames = getResources().getStringArray(R.array.items);
//        int [] itemPrices = getResources().getIntArray(R.array.prices);
//        int [] itemAmount = getResources().getIntArray(R.array.amounts);
//
//        for(int i =0; i<itemNames.length; i++){
//            itemModel.add(new Item_model(itemNames[i],itemPrices[i],itemAmount[i]));
//        }


        for(int i=0; i <itemPrices.length;i++){
            budget_remaining -= itemPrices[i];
        }
        tv.setText("Budget remaining $:" + budget_remaining);
    }

    public void checkout_action(View view){

        int total;
        total = budget_original-budget_remaining;
        Toast.makeText(getApplicationContext(), "total is: $" + total, Toast.LENGTH_LONG).show();

//        Intent intent = new Intent(this,checkout.class);
//        startActivity(intent);



    }


}