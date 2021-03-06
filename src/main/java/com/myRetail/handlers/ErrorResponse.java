package com.myRetail.handlers;

import org.springframework.http.HttpStatus;

/**
 * Created by Lavanya K on 12/28/2016.
 */
public class ErrorResponse {

       private int httpStatus;

       private String httpstatusPhrase;

       private String message;


       public ErrorResponse(HttpStatus httpStatus, String message){
           this.httpStatus = httpStatus.value();
           this.httpstatusPhrase = httpStatus.getReasonPhrase();
           this.message = message;
       }


       public int getHttpStatus() {
           return httpStatus;
       }


       public void setHttpStatus(int httpStatus) {
           this.httpStatus = httpStatus;
       }


       public String getHttpstatusPhrase() {
           return httpstatusPhrase;
       }


       public void setHttpstatusPhrase(String httpstatusPhrase) {
           this.httpstatusPhrase = httpstatusPhrase;
       }


       public String getMessage() {
           return message;
       }


       public void setMessage(String message) {
           this.message = message;
       }
   }
