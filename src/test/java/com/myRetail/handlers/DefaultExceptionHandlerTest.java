package com.myRetail.handlers;

import com.myRetail.Exceptions.DefaultException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Lavanya K on 12/29/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultExceptionHandlerTest {
    @Test
    public void defaultException_handlingTest(){
        DefaultExceptionHandler exceptionHandler = new DefaultExceptionHandler();
        Exception exception = new DefaultException(HttpStatus.NOT_FOUND,"Some message");
        ResponseEntity<ErrorResponse> responseEntity = exceptionHandler.exceptionHandler(exception);
        assertThat(responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND));
        assertThat(responseEntity.getBody().getMessage().equals("Some message"));
        assertThat(responseEntity.getBody().getHttpstatusPhrase().equalsIgnoreCase(HttpStatus.NOT_FOUND.getReasonPhrase()));
        assertThat(responseEntity.getBody().getHttpStatus()==404);
    }
    @Test
       public void allOtherException_handlingTest(){
           DefaultExceptionHandler exceptionHandler = new DefaultExceptionHandler();
           Exception exception = new NullPointerException();
           ResponseEntity<ErrorResponse> responseEntity = exceptionHandler.exceptionHandler(exception);
           assertThat(responseEntity.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR));
       }
}
