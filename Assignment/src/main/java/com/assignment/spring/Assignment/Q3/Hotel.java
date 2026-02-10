package com.assignment.spring.Assignment.Q3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Hotel {
    @Autowired
    Cook cook;
    public void serveFood() {
        cook.food();
    }
}
