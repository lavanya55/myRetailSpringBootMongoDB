package com.myRetail.handlers;

import com.myRetail.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lavanya K on 12/28/2016.
 */
@ControllerAdvice(annotations = RestController.class)
public class DefaultExceptionHandler {
    public DefaultExceptionHandler() {
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception exception) {
        ErrorResponse errorResponseViewBean;
        if (exception instanceof DefaultException) {
            errorResponseViewBean = new ErrorResponse(((DefaultException) exception).getHttpStatus(), ((DefaultException) exception).getDisplayMessage());
        } else {
            errorResponseViewBean = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
        return new ResponseEntity<>(errorResponseViewBean, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}