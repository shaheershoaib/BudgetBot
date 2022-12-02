package com.example.budgetbotcart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity implements Item_RV_Adapter.AdapterCallback {

    ArrayList<Item_model> itemModel = new ArrayList<>();
    int itemCount = 2;
    public static TextView budget_rem;
    int budget_calc;

    private Item_RV_Adapter mMyAdapter;


    @Override
    public void onMethodCallback(String yourValue) {
        TextView tv = findViewById(R.id.budget_rem);
        tv.setText("" +yourValue);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_layout);

        RecyclerView recyclerView = findViewById(R.id.mRecycleView);
        setupItemModel();
        Item_RV_Adapter adapter = new Item_RV_Adapter(this,itemModel);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));






// budget_rem = findViewById(R.id.budget_rem);

// for(int i =0; i<itemModel.size();i++){
// budget_calc += itemModel.get(i).getItemPrice();
//
// }
//
// budget_rem.setText(String.valueOf(budget_calc));


    }

    private void setupItemModel(){
        String[] itemNames = getResources().getStringArray(R.array.items);
        int [] itemPrices = getResources().getIntArray(R.array.prices);
        int [] itemAmount = getResources().getIntArray(R.array.amounts);

        for(int i =0; i<itemNames.length; i++){
            itemModel.add(new Item_model(itemNames[i],itemPrices[i],itemAmount[i]));
        }

    }
}