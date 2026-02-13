package com.assignment.rest.RestApiAssignment.services;

import com.assignment.rest.RestApiAssignment.EmployeeBean.Employee;
import com.assignment.rest.RestApiAssignment.Exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//initailizing a class with component so that its bean can be created by the spring itself
@Component
public class EmployeeService {
    //creating a static list which is used to store the list of employeed
    private static List<Employee> employees=new ArrayList<>();

    //to load the list on the start of the server we add static
    static{
        employees.add(new Employee(1,"Aishwarya",24));
        employees.add(new Employee(2,"Raj",25));
        employees.add(new Employee(3,"Mahika",19));
    }

    //it is used to reterive all employees
    public List<Employee> findAll(){
        return employees;
    }
    //it is used to retierve a employee by checking its id
    public Employee findOne(int id){
        //creating a stream inorder to find the employee and then returning a optional
        Optional<Employee> optional=employees.stream().filter(e->e.getId()==id).findAny();
        //checking that optional is present if present then returning its value
        if(optional.isPresent()){
            return optional.get();
        }else{
            //if not then throw a exception
            throw new UserNotFoundException("User not found");
        }
    }

    //used in post request when a postt request is called then it will add a employee to the list
    public void addOne(Employee employee){
        employees.add(new Employee(employee.getId(),employee.getName(),employee.getAge()));
    }

    //used in delete request when a delete request is called it will delete a employee from the list
    public void deleteOne(int id){
        //creating a stream and finding a employee then returning a optional
        Optional<Employee> optional=employees.stream().filter(e->e.getId()==id).findFirst();
        //if present then delete
        if(optional.isPresent()){
            employees.remove(optional.get());
        }else{
            //if not then throw an exception
            throw new UserNotFoundException("User Not Found");
        }
    }

    //to update a particular employee detail using put request
    public void updateOne(Employee employee,int id){
        //creating a list into stream so that we can find a employee with particular id and converting it into optional
        Optional<Employee> optional=employees.stream().filter(e->e.getId()==id).findFirst();
        //if present then update
        if(optional.isPresent()){
            optional.get().setId(employee.getId());
            optional.get().setName(employee.getName());
            optional.get().setAge(employee.getAge());
        }else{
            //else throw custom exception
            throw new UserNotFoundException("User Not Found");
        }
    }
}
