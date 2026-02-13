package com.assignment.rest.RestApiAssignment.controllers;

import com.assignment.rest.RestApiAssignment.EmployeeBean.Employee;
import com.assignment.rest.RestApiAssignment.services.EmployeeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Q2 {
    //creating a object of employee service so that we can use the services
    EmployeeService employeeService;
    //constructor to initialize its value
    Q2(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    //getmapping annotation is used to reterieve a value
    @GetMapping("/employees")
    public List<Employee> reterieveAllEmployee(){
        return employeeService.findAll(); //findall is used to return all employees
    }

}
