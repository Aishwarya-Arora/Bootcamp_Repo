package com.assignment.spring.Assignment.Q3;

import org.springframework.stereotype.Component;

@Component
public class ChineaseCook implements Cook{
    @Override
    public void food() {
        System.out.println("Can make Chinese food");
    }
}
