package com.assignment.rest.RestApiAssignment.controllers;


import com.assignment.rest.RestApiAssignment.EmployeeBean.Employee;
import com.assignment.rest.RestApiAssignment.services.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Q5 {
   EmployeeService employeeService;

   Q5(EmployeeService employeeService){
       this.employeeService=employeeService;
   }
    //postmapping is used to add a new employee in a list
    @PostMapping("/employees")
    //returning a ResponseEntity object which is used to set a status 201
    public ResponseEntity<Employee> savingEmployees(@Valid @RequestBody Employee employee){
       //checking the validation by using valid annotation
       //RequestBody is used to convert the Json value into the object
       employeeService.addOne(employee); //calling the addOne method
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);    //used to return a status of 201 and sending a body
    }

}
