package com.myRetail.ProductInfo;

import com.myRetail.Exceptions.DefaultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

/**
 * Created by Lavanya K on 12/27/2016.
 */
@Component
public class ProductInfoService {
    private ProductInfoClient productInfoClient;

    @Autowired
    public ProductInfoService(ProductInfoClient productInfoClient){
        this.productInfoClient = productInfoClient;
    }
    public String findProductInfoById(int productId) throws DefaultException {
        String productTitle = null;
        ProductInfo productInfo;
        try {
             productInfo = this.productInfoClient.getProductInfo(productId);
             productTitle= productInfo.getProduct().getItem().getProduct_description().getTitle();
        }catch (HttpClientErrorException ex){
           throw new DefaultException(ex.getStatusCode(), ex.getMessage());
        } catch (RestClientException  | NullPointerException ex){
            if(ex.getMessage()!=null) {
                throw new DefaultException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
            } else{
                throw new DefaultException(HttpStatus.INTERNAL_SERVER_ERROR,"Error at ProductInfoService->findProductInfoById->RestClientException|Nullpointer");
            }
        }
       return productTitle;
    }

}
