package com.myRetail.ProductInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Lavanya K on 12/27/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Product_description {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
