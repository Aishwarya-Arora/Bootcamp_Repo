package com.assignment.spring.Assignment.Q6;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


//Implementation of Tea
@Component
public class ColdTea implements Tea{
    @Override
    public void drink() {
        System.out.println("Cold Tea is ready");
    }
}
