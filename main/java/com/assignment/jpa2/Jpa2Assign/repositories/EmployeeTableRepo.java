package com.assignment.jpa2.Jpa2Assign.repositories;

import com.assignment.jpa2.Jpa2Assign.entities.EmployeeTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTableRepo  extends JpaRepository<EmployeeTable,Long> {
}
