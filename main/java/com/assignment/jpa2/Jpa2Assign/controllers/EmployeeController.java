package com.assignment.jpa2.Jpa2Assign.controllers;

import com.assignment.jpa2.Jpa2Assign.Services.EmployeeService;
import com.assignment.jpa2.Jpa2Assign.entities.Employee;
import com.assignment.jpa2.Jpa2Assign.entities.EmployeeAgeDTO;
import com.assignment.jpa2.Jpa2Assign.entities.EmployeeDTO;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/employees/find")
    public List<EmployeeDTO> findingByNameAndOrder(){
        return employeeService.getEmployeeNameAndOrderByAge();
    }
    @GetMapping("/employees")
    public List<Employee> reterieveAllEmployees(){
        return employeeService.getAllEmployee();
    }
    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeService.saveEmployee(employee));
    }
    @GetMapping("/employees/update/{salary}")
    public ResponseEntity<Integer> updatingEmployees(@PathVariable double salary){
        return ResponseEntity.ok(employeeService.updateEmployeesBySalary(salary));
    }

    @GetMapping("/employees/delete")
    public int deletingEmployees(){
        return employeeService.deleteEmployee();
    }

    @GetMapping("/employees/{name}")
    public List<EmployeeAgeDTO> gettingAllEmployeeHavingSingh(@PathVariable String name){
        return employeeService.retierveEmployeeHavingSingh(name);
    }

    @GetMapping("/employees/delete/{age}")
    public int deletingEmployeeOfAgeGreater(@PathVariable int age){
        return employeeService.deletingEmployeeByAge(age);
    }
}
