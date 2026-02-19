package com.assignment.jpa2.Jpa2Assign.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeAgeDTO {
    private long id;
    private String firstName;
    private int age;
    public EmployeeAgeDTO(long id,String firstName,int age){
        this.id=id;
        this.firstName=firstName;
        this.age=age;
    }
}
