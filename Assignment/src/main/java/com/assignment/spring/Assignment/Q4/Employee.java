package com.assignment.spring.Assignment.Q4;

import lombok.Getter;
import org.springframework.stereotype.Component;


//Employee class will have some fields and a constructor
//Component annotation will tell the spring to create a bean instance of this class
@Component

//It will automatically make the getters and it is present in lombok dependency
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
