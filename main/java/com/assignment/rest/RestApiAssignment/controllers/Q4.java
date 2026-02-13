package com.assignment.rest.RestApiAssignment.controllers;

import com.assignment.rest.RestApiAssignment.EmployeeBean.Employee;
import com.assignment.rest.RestApiAssignment.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Q4 {

    //creating a object of employee services so that i can access the services of that class
    EmployeeService employeeService;

    //initializing the value so that we don't get nullpointerexception
    Q4(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    //getmapping at /employee/id where id is a pathvariable means we can give variable values in place of id
    @GetMapping("/employees/{id}")
    public Employee retierveOneEmployee(@PathVariable int id){  //capturing the value inside the id variable
        return employeeService.findOne(id);     //calling findone method which has the logic to retierve a particular employee by id
    }
}
