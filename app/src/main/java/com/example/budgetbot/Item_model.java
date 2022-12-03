package com.example.budgetbot;

import android.widget.Button;

public class Item_model {

    String itemName;
    int itemPrice;
    int itemAmount;
//    Button plus_button;

//    public Item_model(String itemName, int itemPrice) {
//        this.itemName = itemName;
//        this.itemPrice = itemPrice;
//    }

    public Item_model(String itemName, int itemPrice, int itemAmount) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemAmount = itemAmount;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }
}
