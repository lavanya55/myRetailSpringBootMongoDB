package com.myRetail.Products;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by Lavanya K on 12/28/2016.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ProductsController.class)
public class ProductsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @Test
    public void testProductControllerMvc() throws Exception {
        Products product = new Products();
        product.setName("Some name");
        product.setProductId(1234);
        CurrentPrice currentPrice = new CurrentPrice();
        currentPrice.setCurrencyCode("USD");
        currentPrice.setValue("12");
        product.setCurrentPrice(currentPrice);
        given(this.productService.findProductById(1234))
                .willReturn(product);
        this.mvc.perform(get("/v1/products/1234"))
                .andExpect(status().isOk()).andExpect(content().string("{\"productId\":1234,\"name\":\"Some name\",\"currentPrice\":{\"value\":\"12\",\"currencyCode\":\"USD\"}}"));
    }

}
