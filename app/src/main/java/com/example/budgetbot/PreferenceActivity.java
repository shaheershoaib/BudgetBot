package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class PreferenceActivity extends AppCompatActivity {
    ArrayList<String> productType = new ArrayList<>();

    private SearchView searchView;
    productPref_RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_preference);
        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        Button recommendButton = (Button)findViewById(R.id.submitBtn);
        Intent goToRecommendFromPref = new Intent(this, Recommendation.class);
        recommendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(goToRecommendFromPref);

            } });



        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);



        setProductTypeList();

         adapter = new productPref_RecyclerViewAdapter(this, productType);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void filterList(String text) {
        ArrayList<String> filteredList = new ArrayList<>();
        for(String type: productType){
            if(type.toLowerCase().contains(text.toLowerCase())){
                filteredList.add(type);
            }
        }

        if(filteredList.isEmpty()){

        }else{
            adapter.setFilteredList(filteredList);

        }

    }

    private void setProductTypeList(){
       String[] prod_types = getResources().getStringArray(R.array.product_type);
       for(int i=0;i<prod_types.length;i++){
           productType.add(prod_types[i]);
       }
    }

    public void backToSearch(View view){
        Intent intent = new Intent(this, SearchProducts.class);
        startActivity(intent);
    }

    public void storePreferences(View view){
        RecyclerView rec = findViewById(R.id.mRecyclerView);
        //  rec.getScrollBarSize();
        String fileContents = "";
        for (int i = 0; i < rec.getChildCount(); i++) {
            TextView quantityTxt = (TextView) rec.findViewHolderForAdapterPosition(i).itemView.findViewById(R.id.quantityTxt);
            TextView productText = (TextView) rec.findViewHolderForAdapterPosition(i).itemView.findViewById(R.id.textView2);
            Spinner typeSpinner = (Spinner) rec.findViewHolderForAdapterPosition(i).itemView.findViewById(R.id.spinner3);;
            String product = productText.getText().toString();
            String quantity = quantityTxt.getText().toString();
            String type = typeSpinner.getSelectedItem().toString();
            // String fileContents = tvName.getText()+", " + tvPrice.getText() + "\n";
            if(Integer.parseInt(quantity)!=0)
                fileContents = fileContents + product + ", " + type + ", " + quantity + "\n";
        }


        String filename = "preferences.txt";

        FileOutputStream outputStream;  //Allow a file to be opened for writing


        try {
            outputStream = openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(fileContents.getBytes());    //FileOutputStream is meant for writing streams of raw bytes.
            outputStream.close();
            Toast.makeText(this, "Preferences stored successfully.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }


}