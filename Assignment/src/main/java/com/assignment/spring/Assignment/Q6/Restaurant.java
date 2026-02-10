package com.assignment.spring.Assignment.Q6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
    //independent object
    Tea tea;
    @Autowired
    //Constructor injection and using Qualifier will give the reference of that class
    public Restaurant(@Qualifier("coldTea") Tea tea) {
        this.tea = tea;
    }

    //calling the implementation using the object
    public void serve(){
        tea.drink();
    }
}
