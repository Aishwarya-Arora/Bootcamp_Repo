package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//creating Employee class
class Employee1{
    String fullname;
    long salary;
    String city;

    //constructor
    Employee1(String fullname,long salary,String city){
        this.fullname=fullname;
        this.salary=salary;
        this.city=city;
    }
    public long getSalary() {
        return salary;
    }

    public String getFullName() {
        return fullname;
    }

    public String getCity() {
        return city;
    }
}
public class Ques9 {
    static void main(String[] args) {
        List<Employee1> employees=new ArrayList<>();    //creating a arraylist object

        //adding some elements in the list
        employees.add(new Employee1("Aishwarya Arora",1500,"Delhi"));
        employees.add(new Employee1("Ram Kumar",30000,"Goa"));
        employees.add(new Employee1("Rajni Rai",40000,"Agra"));
        employees.add(new Employee1("Mahika Gupta",2000,"Delhi"));


        //here first of all to apply any method to the list converting it to stream using stream method
       List<String> list= employees.stream()
                .filter(e -> e.getSalary() < 5000)      //filtering the employee by checking the salary <5000
                .filter(e -> "delhi".equalsIgnoreCase(e.getCity()))     //filtering the employee who lives in delhi and we can check it using equals or equalsignorecase to ignore case sensitivity
                .map(e -> e.getFullName().split(" ")[0]) // now we have to get the first name only we can get it using split method and taking the 0th index of each array so that firstname will only come
                .distinct() //distinct is used to get the unique values
                .collect(Collectors.toList());  //converting the stream to list
        System.out.println(list);
    }
}
