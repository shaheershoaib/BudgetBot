package com.example.project341;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

public class LampsActivity extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamps);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }
}