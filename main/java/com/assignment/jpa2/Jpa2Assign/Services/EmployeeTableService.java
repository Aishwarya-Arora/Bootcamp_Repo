package com.assignment.jpa2.Jpa2Assign.Services;

import com.assignment.jpa2.Jpa2Assign.entities.Employee;
import com.assignment.jpa2.Jpa2Assign.entities.EmployeeTable;
import com.assignment.jpa2.Jpa2Assign.entities.SalaryDetails;
import com.assignment.jpa2.Jpa2Assign.repositories.EmployeeRepository;
import com.assignment.jpa2.Jpa2Assign.repositories.EmployeeTableRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTableService {
    @Autowired
    EmployeeTableRepo employeeTableRepo;

    @Transactional
    public void createEmployeeDemo() {
        SalaryDetails salary = new SalaryDetails(
                10000, 2000, 30000, 4000
        );

        EmployeeTable emp = new EmployeeTable(1L, "Aishwarya", "Arora", 28, salary);

        employeeTableRepo.save(emp);

        System.out.println("Employee saved with embedded salary details!");
    }
}
