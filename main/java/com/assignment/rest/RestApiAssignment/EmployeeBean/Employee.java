package com.assignment.rest.RestApiAssignment.EmployeeBean;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


//Getter annotation is a lombok annotation which is used to create a getter for the class
@Getter
//setter annotation is a lombok annotation which is used to create a setter for the class
@Setter
public class Employee {
    //Not Null Validation is used to check whether a value is null or not
    @NotNull(message = "Id cannot be null")
    private int id; //id can't be null
    //min validation is used to check the minimum value for a particular field
    @Min(value = 18, message = "Age must be at least 18")
    private int age; //age can't be less than 18
    //Not blank annotation is used to check whether the value is blank or not
    @NotBlank(message = "Name can't be blank")
    private String name;        //name field can't be blank

    //A constructor that is used to initialize the values of fields
    public Employee(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }
}
