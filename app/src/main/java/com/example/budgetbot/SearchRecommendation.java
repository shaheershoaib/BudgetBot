package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unchecked")

public class SearchRecommendation extends AppCompatActivity {

    private ArrayAdapter arrayAdapter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        int budget = (intent.getIntExtra("budget",0));


        ListView listview= findViewById(R.id.listview);
        EditText theFilter = (EditText) findViewById(R.id.searchFilter);

        List<String> list = new ArrayList<>();
        list.add("Chairs");
        list.add("Tables");
        list.add("Lamps");



        arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listview.setAdapter(arrayAdapter);


        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (SearchRecommendation.this).arrayAdapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i == 0){

                    startActivity(new Intent(SearchRecommendation.this, ChairActivity.class));
                }else if (i == 1){

                    startActivity(new Intent(SearchRecommendation.this, TableActivity.class));

                }else {

                    startActivity(new Intent(SearchRecommendation.this, LampsActivity.class));
                }
            }
        });

    }
}