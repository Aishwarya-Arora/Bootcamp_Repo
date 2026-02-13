package com.assignment.rest.RestApiAssignment.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//simple api that will print the string
@RestController             //RestController is the controller which has the response body
public class Q1 {

    @GetMapping("/welcome")         //get request having the endpoint /welcome
    public String welcomeMessage(){
        return "Welcome to Spring Boot";        //when hit the /welcome endpoint it will return this string
    }
}
