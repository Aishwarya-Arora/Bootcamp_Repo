package com.assignment.spring.Assignment.Q3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Hotel {
    //Autowired is used to inject the dependency inside the Hotel object
    @Autowired
    Cook cook;
    public void serveFood() {
        cook.food(); //It will tell which object to call
    }
}
