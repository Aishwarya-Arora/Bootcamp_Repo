package com.assignment.jpa.Jpa1Assignment.repositories;

import com.assignment.jpa.Jpa1Assignment.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//It is used to tell that it is a repository
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //In order to use the methods of Jpa we have to extend the JpaRepository with the entity name and the type of primary key
    List<Employee> findByName(String name);
    //to find the employee by the name hence returning a list of employee
    List<Employee> findByNameLike(String name);
    //creating a method where we can use like keyword to match a pattern
    List<Employee> findByAgeBetween(int age1,int age2);
    //creating a finder method to find the employees between 28 to 32
    Page<Employee> findByLocationIn(List<String> locations,Pageable pageable);
}
