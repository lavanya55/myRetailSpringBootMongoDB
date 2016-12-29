package com.myRetail.ProductInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Lavanya K on 12/27/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductInfo {
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
