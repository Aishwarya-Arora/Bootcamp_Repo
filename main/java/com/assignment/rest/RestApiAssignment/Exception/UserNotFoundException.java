package com.assignment.rest.RestApiAssignment.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

//Setting the custom Exception by extending it with RuntimeException
public class UserNotFoundException extends RuntimeException {
    //calling the constructor which is calling the Runtime Exception constructor
    public UserNotFoundException(String message) {
        super(message);
    }
}
