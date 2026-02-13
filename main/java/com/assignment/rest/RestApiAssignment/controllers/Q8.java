package com.assignment.rest.RestApiAssignment.controllers;


import com.assignment.rest.RestApiAssignment.EmployeeBean.Employee;
import com.assignment.rest.RestApiAssignment.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Q8 {
    EmployeeService employeeService;

    Q8(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    //put mapping is used to update a particular employee of id given in url
    @PutMapping("/employees/{id}")
    //returning a respone entity
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable int id){
        employeeService.updateOne(employee,id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(employee); //setting the status as 204 and giving the employee as response
    }
}
