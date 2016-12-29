package com.myRetail.Products;

/**
 * Created by Lavanya K on 12/27/2016.
 */
public class Products {

    private int productId;
    private String name;
    private CurrentPrice currentPrice;

    public Products(){

    }
    public CurrentPrice getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(CurrentPrice currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int id) {
        this.productId = id;
    }



}
