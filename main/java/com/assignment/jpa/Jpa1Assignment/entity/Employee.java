package com.assignment.jpa.Jpa1Assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//Entity is used to tell that it is going to be the the table saved in the database
@Entity
@Getter
@Setter
public class Employee {
    //Employee Entity which is going to be napped to database
    //Id tag is used to tell the primary key
    @Id
    private Long id;
    private String name;
    private String location;
    private int age;
}
