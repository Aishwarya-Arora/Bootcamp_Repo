package com.assignment.spring.Assignment.Q3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ItalianCook implements Cook {
    @Override
    public void food() {
        System.out.println("Can make Italian food");
    }
}
