package com.example.demo.Q2;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//lombok annotation
@Setter
@Getter

//Component annotation to say spring to create it's instance
@Component

//Defining the configuration properties so that i can use the refernce in application.properties
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private String name;
    private String version;
    private String description;


}
