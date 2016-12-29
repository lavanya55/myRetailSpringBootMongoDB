package com.myRetail.ProductInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Lavanya K on 12/27/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Product {
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
