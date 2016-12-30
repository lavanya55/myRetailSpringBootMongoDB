package com.myRetail.Products;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

    @Test
    public void testProductControllerMvcForPut() throws Exception {
        Products product = new Products();
        product.setName("Some name");
        product.setProductId(1234);
        CurrentPrice currentPrice = new CurrentPrice();
        currentPrice.setCurrencyCode("USD");
        currentPrice.setValue("12");
        product.setCurrentPrice(currentPrice);

        Products product1 = new Products();
        product1.setName("Some name");
        product1.setProductId(1234);
        CurrentPrice currentPrice1 = new CurrentPrice();
        currentPrice1.setCurrencyCode("Rs");
        currentPrice1.setValue("200");
        product1.setCurrentPrice(currentPrice1);

        given(this.productService.updateProduct(product))
                .willReturn(product1);


        this.mvc.perform(put("/v1/products/1234").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(convertObjectToJsonBytes(product)))
                .andExpect(status().isOk()).andExpect(status().isOk());
    }
    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return mapper.writeValueAsBytes(object);
        }


}
