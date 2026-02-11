package com.example.demo;

import com.example.demo.Q2.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NewProjectApplication {


	AppProperties appProperties;
	@Autowired


	public static void main(String[] args) {
		//creating a application context using the SpringApplication.run
		ApplicationContext context=SpringApplication.run(NewProjectApplication.class, args);
		//getting the bean from the context
		AppProperties appProperties= context.getBean(AppProperties.class);
		//getting the values by using getters
		System.out.println("App Name: " + appProperties.getName());
		System.out.println("App Version: " + appProperties.getVersion());
		System.out.println("App Description: " + appProperties.getDescription());
	}

}
