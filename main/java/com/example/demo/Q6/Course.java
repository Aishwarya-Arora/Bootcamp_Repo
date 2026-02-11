package com.example.demo.Q6;

import lombok.Getter;

//lombok annotation
@Getter

//Course class which is created in order to create a course object which is used in making the list
public class Course {
    String name;
    int id;
    Course(String name,int id){
        this.name=name;
        this.id=id;
    }
}
