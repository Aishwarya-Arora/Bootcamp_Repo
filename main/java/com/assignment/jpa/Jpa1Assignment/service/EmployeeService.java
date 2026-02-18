package com.assignment.jpa.Jpa1Assignment.service;

import com.assignment.jpa.Jpa1Assignment.entity.Employee;
import com.assignment.jpa.Jpa1Assignment.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@Service
public class EmployeeService {
    //To use the employeeRepository in EmployeeService we use dependency injection
    @Autowired
    EmployeeRepository employeeRepository;
    //method to reterieve all the employees
    public List<Employee> retierveEmployee(){
        //findall method is used to reterieve all the list of employees
        return employeeRepository.findAll();
    }
    //method to create a employee
    public void saveEmployee(Employee employee){
        //we can use save method to insert the object as a record in tab;e
        employeeRepository.save(employee);
    }
    //method to update employee by getting the id from the url using path variable
    public void updatingEmployee(Employee employee,long id) {
        List<Employee> list = employeeRepository.findAll();
        //getting all the employees so that we can easily iterate over it
        Employee employee1 = list.stream().filter(emp -> emp.getId() == id).findAny().orElseThrow(() -> new RuntimeException("not found"));
        //iterating over the list and then setting the vaue in that object
        employee1.setName(employee.getName());
        employee1.setAge(employee.getAge());
        employee1.setLocation(employee.getLocation());
        //saving its value
        employeeRepository.save(employee1);
    }
    //deleting a employee by id
    public void deletingEmployee(long id){
        employeeRepository.deleteById(id);
    }

    //count the employees with the help of count method which is going to return long value
    public long countEmployee(){
        return employeeRepository.count();
    }

    //to do paging and sorting we can use findAll method which is having Pageable object which is created using PageRequest.of method and in that function we can pass sort direction as well as page size and page no
    public Page<Employee> pagingAndSorting(int pageSize,int pageNumber){
        //accepting the pagesize and page number using the url and passing it inside the argument to not to hardcode the value
        return employeeRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(Sort.Direction.DESC,"age")));
    }
    //it will return a list of employees by giving a name inside the argument
    public List<Employee> findName(String name){
        return employeeRepository.findByName(name);
    }
    //calling a method that is defined inside the repository
    public List<Employee> findExp(String exp){
        return employeeRepository.findByNameLike(exp);
    }
    //calling repository method
    public List<Employee> findingAgeBetween(int age1,int age2){
        return employeeRepository.findByAgeBetween(age1,age2);
    }
    public Page<Employee> findingInandPaging(List<String> locations,int pageNumber,int pageSize){
        return employeeRepository.findByLocationIn(locations,PageRequest.of(pageNumber,pageSize,Sort.by(Sort.Direction.DESC,"name")));
    }
}
