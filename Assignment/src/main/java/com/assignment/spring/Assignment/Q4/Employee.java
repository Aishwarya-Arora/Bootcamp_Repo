package com.assignment.spring.Assignment.Q4;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Employee {
    private int age;
    private String name;
    private String designation;
    Employee(){
        this.age=14;
        this.name="Aishwarya";
        this.designation="Trainee";
    }

}
