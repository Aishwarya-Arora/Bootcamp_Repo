package com.assignment.spring.Assignment.Q3;

import org.springframework.stereotype.Component;


//Same method with a component annotation telling spring to create a bean instance in the spring container
@Component
public class ChineaseCook implements Cook{
    @Override
    public void food() {
        System.out.println("Can make Chinese food");
    }
}
