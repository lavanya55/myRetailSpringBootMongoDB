package com.myRetail.ProductInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Lavanya K on 12/27/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Item {
    private Product_description product_description;

    public Product_description getProduct_description() {
        return product_description;
    }

    public void setProduct_description(Product_description product_description) {
        this.product_description = product_description;
    }
}
