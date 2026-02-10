package com.assignment.spring.Assignment.Q3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


//Making it a component so that spring can easily recognize that spring has to create a bean instance
@Component

//This is written in order to resolve the conflict which is generated when we have multiple implementations of a similar method
@Primary
public class ItalianCook implements Cook {
    @Override
    public void food() {
        System.out.println("Can make Italian food");
    }
}
