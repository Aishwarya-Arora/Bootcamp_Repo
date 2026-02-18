package com.assignment.jpa.Jpa1Assignment.controller;

import com.assignment.jpa.Jpa1Assignment.entity.Employee;
import com.assignment.jpa.Jpa1Assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    //creating a object of employeeService so that we can use its method we can also directly access the reppository but it is not recommended
    @GetMapping("/employees")
    public List<Employee> retierveAllEmployee() {
        return employeeService.retierveEmployee();
    }
    //to create a new employee
    @PostMapping("/employees")
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        //this method is going to return a response entity which is used to return a json
        employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);    //here we are returning a json with the status 201
    }
    //to update the user we have to give the id inorder to tell which one to update
    @PutMapping("/employees/{id}")
    //given path variable in order to get it from the url
    public ResponseEntity updateEmployee(@RequestBody Employee employee,@PathVariable int id) {
        //returning a response entity in order to set 204 http status code
        employeeService.updatingEmployee(employee,id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(employee);
    }
    //deleting a employee by id
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
        //returning the response entity which will tell whether we have deleted the employee of that id or not
        employeeService.deletingEmployee(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted");
    }
    //getting the count value at /employees/count end point
    @GetMapping("/employees/count")
    public long countingEmployee(){
        return employeeService.countEmployee();
    }
    //pagination and sorting using requestParam which is used to set the value for pagesize and pagenumber in header
    @GetMapping("/employees/page")
    public Page<Employee> pageAndSort(@RequestParam int pageSize,@RequestParam int pageNumber){
        return employeeService.pagingAndSorting(pageSize,pageNumber);
    }
    //to find a employee by name  we use pathvariable
    @GetMapping("/employees/{name}")
    public List<Employee> findEmployeeByName(@PathVariable String name){
        return employeeService.findName(name);  //calling service method and sending a name argument inside it
    }
    //finding all the employee having name start with A it can return a list of employees
    @GetMapping("/employees/regex/{exp}")
    public List<Employee> findEmployeeByExp(@PathVariable String exp){
        //calling a service method
        return employeeService.findExp(exp+"%");
    }
    //finding a employee having age between 28 to 32
    @GetMapping("/employees/between/{age1}/{age2}")
    public List<Employee> findAgeBetween(@PathVariable int age1,@PathVariable int age2){
        return employeeService.findingAgeBetween(age1, age2);
    }

    @GetMapping("/employees/paging")
    public Page<Employee> findIds(@RequestParam List<String> locations,@RequestParam int pageSize,@RequestParam int pageNumber){
        return employeeService.findingInandPaging(locations,pageNumber,pageSize);
    }
}
