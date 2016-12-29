package com.myRetail.ProductInfo;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Lavanya K on 12/28/2016.
 */
@Component
public class ProductInfoClient {
    protected ProductInfo getProductInfo(int productId){
         RestTemplate restTemplate = new RestTemplate();
         return restTemplate.getForObject("http://redsky.target.com/v1/pdp/tcin/{id}?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics,available_to_promise_network", ProductInfo.class, productId);
       }
}
