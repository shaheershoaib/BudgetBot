package com.example.budgetbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class TableActivity extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        ImageButton cartButton = (ImageButton)findViewById(R.id.imageButton);
        Intent cartIntent = new Intent(this, Cart.class);

        Intent intent = getIntent();
        int budget = (intent.getIntExtra("budget",0));
        TextView budgetRem = (TextView) findViewById(R.id.textView2);
        budgetRem.setText("$"+String.valueOf(budget));

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(cartIntent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}