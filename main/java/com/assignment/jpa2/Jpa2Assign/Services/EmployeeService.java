package com.assignment.jpa2.Jpa2Assign.Services;

import com.assignment.jpa2.Jpa2Assign.entities.Employee;
import com.assignment.jpa2.Jpa2Assign.entities.EmployeeAgeDTO;
import com.assignment.jpa2.Jpa2Assign.entities.EmployeeDTO;
import com.assignment.jpa2.Jpa2Assign.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getEmployeeNameAndOrderByAge(){
        List<Object[]> result=employeeRepository.findNameAndLastNameOrderByAgeAndSalary(employeeRepository.findAverageSalary());
        return result.stream().map(obj->new EmployeeDTO((String)obj[0],(String) obj[1])).toList();
    }
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public int updateEmployeesBySalary(double salary){
        return employeeRepository.updateEmployees(salary,employeeRepository.findAverageSalary());
    }

    public int deleteEmployee(){
        return employeeRepository.deleteEmployeesHavingSalaryLess(employeeRepository.findingMin());
    }

    public List<EmployeeAgeDTO> retierveEmployeeHavingSingh(String name) {
        List<Object[]> result=employeeRepository.findingNameWithSingh(name);
        return result.stream().map(obj->new EmployeeAgeDTO((Long)obj[0],(String)obj[1],(Integer) obj[2])).toList();
    }

    public int deletingEmployeeByAge(int age){
        return employeeRepository.deleteEmployeeByAge(age);
    }
}
