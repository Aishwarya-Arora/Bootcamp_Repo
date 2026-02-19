package com.assignment.jpa2.Jpa2Assign.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
public class EmployeeTable {
    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private int age;

    @Embedded
    private SalaryDetails salaryDetails;

    public EmployeeTable() {

    }
}
