package com.assignment.spring.Assignment;

import com.assignment.spring.Assignment.Q3.Hotel;
import com.assignment.spring.Assignment.Q4.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(AssignmentApplication.class, args);
		Hotel hotel=context.getBean(Hotel.class);
		hotel.serveFood();
		Employee employee=context.getBean(Employee.class);
		System.out.println(employee.getAge()+" | "+employee.getName()+" | "+employee.getDesignation());

	}


}
