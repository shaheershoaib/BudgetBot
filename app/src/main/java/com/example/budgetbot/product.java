package com.example.budgetbot;

public class product {
    String productName;
    int productPrice;
    int productImage;


    public product(String productName, int productPrice, int productImage) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
    }


    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getProductImage() {
        return productImage;
    }
}
