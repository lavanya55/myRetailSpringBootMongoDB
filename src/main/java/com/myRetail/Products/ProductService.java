package com.myRetail.Products;

import com.myRetail.Exceptions.DefaultException;
import com.myRetail.ProductInfo.ProductInfoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by Lavanya K on 12/27/2016.
 */
@Component
public class ProductService {
    private ProductInfoService productInfoService;
    private ProductsRepository productsRepository;

    @Autowired
    public ProductService(ProductInfoService productInfoService, ProductsRepository productsRepository) {
        this.productInfoService = productInfoService;
        this.productsRepository = productsRepository;
    }

    public Products findProductById(int productId) throws DefaultException {

        //get product name from rest service
        String productName = this.productInfoService.findProductInfoById(productId);


        //get product price details from mongoDB
        ProductsDao productDao = this.productsRepository.findByProductId(productId);
        if (productDao == null) {
            throw new DefaultException(HttpStatus.NOT_FOUND, "Record not found in database");
        }


        //prepare the model object and return
        Products products = convertEntityToModel(productDao);
        products.setName(productName);

        return products;
    }

    private Products convertEntityToModel(ProductsDao productDao) {
        Products products;
        ModelMapper mapper = new ModelMapper();
        products = mapper.map(productDao, Products.class);

        return products;
    }
}
