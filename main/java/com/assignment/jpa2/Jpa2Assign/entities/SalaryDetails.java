package com.assignment.jpa2.Jpa2Assign.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
public class SalaryDetails {

    private double basicSalary;
    private double bonusSalary;
    private double taxAmount;
    private double specialAllowanceSalary;

    public SalaryDetails() {

    }
}