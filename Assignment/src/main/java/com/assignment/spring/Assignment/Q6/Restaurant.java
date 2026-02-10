package com.assignment.spring.Assignment.Q6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
    Tea tea;
    @Autowired
    Restaurant(Qualifier("coldTea")Tea tea){
        this.tea=tea;
    }
    public void serve(){
        tea.drink();
    }
}
