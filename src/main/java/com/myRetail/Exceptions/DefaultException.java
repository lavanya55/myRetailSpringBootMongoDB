package com.myRetail.Exceptions;

import org.springframework.http.HttpStatus;

/**
 * Created by Lavanya K on 12/28/2016.
 */
public class DefaultException extends Exception {
    private HttpStatus httpStatus;
    private String displayMessage;

    public DefaultException(HttpStatus status,String displayMessage){
        this.httpStatus=status;
        this.displayMessage=displayMessage;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}
