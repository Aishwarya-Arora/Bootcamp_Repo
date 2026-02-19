package com.assignment.jpa2.Jpa2Assign.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="employeeTable")
public class Employee {
    @Column(name = "empId")
    @Id
    private long id;
    @Column(name="empFirstName")
    private String firstName;
    @Column(name="empLastName")
    private String lastName;
    @Column(name="empSalary")
    private Double salary;
    @Column(name="empAge")
    private int age;
}
