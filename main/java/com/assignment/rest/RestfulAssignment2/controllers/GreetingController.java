package com.assignment.rest.RestfulAssignment2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class GreetingController {

    @Autowired
    private MessageSource messageSource;
    //It is used to read the messages.properties file
    @GetMapping("/greet")
    public String greet(@RequestParam String username, Locale locale) {

        return messageSource.getMessage(
                "greeting.message",
                new Object[]{username},     //Used to represnt the array of values passed inside the message.properties
                locale
        );
    }
}