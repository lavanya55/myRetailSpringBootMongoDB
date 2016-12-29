package com.myRetail.Products;

import com.myRetail.Exceptions.DefaultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lavanya K on 12/27/2016.
 */
@RestController
@Scope("prototype")
public class ProductsController {
    private ProductService productService;

    public ProductsController() {
    }
    @Autowired
    public ProductsController(ProductService productService){
        this.productService = productService;
    }
    @RequestMapping(method= RequestMethod.GET, value = "v1/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Products getProductById(@PathVariable("productId") int productId) throws DefaultException {
        return this.productService.findProductById(productId);
    }

}
