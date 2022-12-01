package com.example.testingrec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class SearchProducts extends AppCompatActivity {

    private SearchView searchView;
    ArrayList<product> productList = new ArrayList<>();
    private product_RecyclerViewAdapter productAdapter;

    int[] productImages = {R.drawable.gaming_chair, R.drawable.office_chair, R.drawable.wooden_chair,
    R.drawable.kitchen_chair, R.drawable.ashby_sofa_grey, R.drawable.sofa_blue, R.drawable.sofa_green,
    R.drawable.fridge_grey, R.drawable.samsung_fridge, R.drawable.wooden_round_table,
            R.drawable.wooden_rectangular_table, R.drawable.nesting_coffee_table};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_products);




        //Toast.makeText(this, "Inside of oncreate of main", Toast.LENGTH_LONG).show();

        searchView = findViewById(R.id.searchView);


        searchView.clearFocus();


       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
              //  InputMethodManager imm =  (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
             //   imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
                filterList(newText);
                return false;
            }
        });
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView2);
        //Toast.makeText(this, "After recylervire find Id", Toast.LENGTH_LONG).show();

        setUpProductList();
       // Toast.makeText(this, "After setting up product list", Toast.LENGTH_LONG).show();


         productAdapter = new product_RecyclerViewAdapter(this, productList);
       // Toast.makeText(this, "After initializing  the adapter", Toast.LENGTH_LONG).show();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
      //  Toast.makeText(this, "After Setting up the layout manager", Toast.LENGTH_LONG).show();

        //try {
            recyclerView.setAdapter(productAdapter);
         //   Toast.makeText(this, "After Setting up the adapter", Toast.LENGTH_LONG).show();

       // }catch(Exception e) {
        //    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();

        //}


    }

    private void filterList(String text) {
        ArrayList<product> filteredList = new ArrayList<>();
        for(product prod : productList){
            if(prod.getProductName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(prod);
            }
        }

        if(filteredList.isEmpty()){
            Toast.makeText(this, "No product found", Toast.LENGTH_SHORT).show();
        }else{
            //RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

           //product_RecyclerViewAdapter adapter = new product_RecyclerViewAdapter(this, filteredList);
           productAdapter.setFilteredList(filteredList);
           // RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            //recyclerView.setLayoutManager(layoutManager);
            //recyclerView.setItemAnimator(new DefaultItemAnimator());
            //recyclerView.setAdapter(adapter);

        }
    }

    private void setUpProductList(){
        String[] productNames = getResources().getStringArray(R.array.product_names);
        int[] productPrices = getResources().getIntArray(R.array.prices);
        for(int i=0;i<productNames.length;i++){
            productList.add(new product(productNames[i], productPrices[i], productImages[i]));

        }

    }

    //File write operation
    public void writeFileContent(String fileContents) {
        String filename = "cart.txt";

        FileOutputStream outputStream;  //Allow a file to be opened for writing


        try {
            outputStream = openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(fileContents.getBytes());    //FileOutputStream is meant for writing streams of raw bytes.
            outputStream.close();
            Toast.makeText(this, "Item added successfully", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void recommednPage(View view){
        Intent intent = new Intent(this, PreferenceActivity.class);
        startActivity(intent);
    }

}