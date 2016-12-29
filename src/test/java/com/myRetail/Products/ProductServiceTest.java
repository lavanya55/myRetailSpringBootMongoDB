package com.myRetail.Products;

import com.myRetail.Exceptions.DefaultException;
import com.myRetail.ProductInfo.Product;
import com.myRetail.ProductInfo.ProductInfo;
import com.myRetail.ProductInfo.ProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * Created by Lavanya K on 12/28/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @MockBean
    private ProductsRepository productsRepository;
    @MockBean
    private ProductInfoService productInfoService;
    @Autowired
    private ProductService productService;

    @Test(expected = DefaultException.class)
    public void findProductById_NullDaoTest() throws DefaultException {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProduct(new Product());

        when(productInfoService.findProductInfoById(anyInt())).thenReturn("Some name");
        when(productsRepository.findByProductId(anyInt())).thenReturn(null);
        productService.findProductById(1234);
    }

    @Test(expected = DefaultException.class)
    public void findProductById_ProductInfoThrowsExceptionTest() throws DefaultException {
        doThrow(new DefaultException(HttpStatus.NOT_FOUND, "some message")).when(productInfoService).findProductInfoById(anyInt());
        productService.findProductById(1234);
    }

    @Test
    public void findProductById_HappyPathTest() throws DefaultException {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProduct(new Product());

        ProductsDao productsDao = new ProductsDao();
        CurrentPrice currentPrice = new CurrentPrice();
        currentPrice.setValue("12");
        currentPrice.setCurrencyCode("USD");
        productsDao.setCurrentPrice(currentPrice);
        productsDao.setProductId(1234);
        when(productInfoService.findProductInfoById(anyInt())).thenReturn("Some name");
        when(productsRepository.findByProductId(anyInt())).thenReturn(productsDao);
        Products product = productService.findProductById(1234);
        assertThat(product.getName().equalsIgnoreCase("Some name"));
        assertThat(product.getProductId()==1234);
        assertThat(product.getCurrentPrice().getValue().equalsIgnoreCase("12"));
        assertThat(product.getCurrentPrice().getCurrencyCode().equalsIgnoreCase("USD"));
    }


}
