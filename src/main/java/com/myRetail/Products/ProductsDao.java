package com.myRetail.Products;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Repository;

/**
 * Created by Lavanya K on 12/27/2016.
 */
@Document(collection = "Product")
@Repository
public class ProductsDao {
    @Id
    private String id;
    @Field("id")
    private int productId;
    private CurrentPrice CurrentPrice;

    public ProductsDao(){

    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int id) {
        this.productId = id;
    }

    public CurrentPrice getCurrentPrice() {
        return CurrentPrice;
    }

    public void setCurrentPrice(CurrentPrice currentPrice) {
        this.CurrentPrice = currentPrice;
    }




}
