package com.assignment.rest.RestApiAssignment.controllers;

import com.assignment.rest.RestApiAssignment.EmployeeBean.Employee;
import com.assignment.rest.RestApiAssignment.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Q7 {
    EmployeeService employeeService;
    Q7(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    //delete mapping is used to delete a particular employee
    @DeleteMapping("/employees/{id}") //id is variable means we can put any integer in place of id
    //returning the response entity object
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){ //capturing the value in id variable
        employeeService.deleteOne(id); //calling a deleteOne method
        return ResponseEntity.status(200).body("Deleted");  //sending the status 200 with a body containing the string deleted
    }
}
