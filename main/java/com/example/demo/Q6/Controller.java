package com.example.demo.Q6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//restcontroller is used to return a json object means a response body
@RestController
public class Controller {


    //get request on /course endpoint it will return a list of courses
    @GetMapping("/course")
    public List<Course> getAllCourse(){
        return Arrays.asList(new Course("JAVA",1),
                            new Course("JS",2),
                            new Course("Devops",3)

                );
    }
}
