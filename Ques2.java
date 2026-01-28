package Collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
class SalaryComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee e1, Employee e2) {
        //Compare is used to do custom sorting and it is present in Comparator it will be always executed on Wrapper Classes that's why i have created instance variable of Wrapper class
        return e1.getSalary().compareTo(e2.getSalary());
    }
}
class Employee implements Comparable<Employee> {
    private String lname;
    private Double age;
    private Double salary;
    private String fname;
    //parameterized Constructor
    Employee(Double age,Double salary,String fname,String lname){
        this.age=age;
        this.salary=salary;
        this.fname=fname;
        this.lname=lname;
    }
    //getters
    public Double getAge(){
        return this.age;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "name :-"+fname+" "+ lname+" | salary :- "+age+" | salary :-"+salary;
    }
    //whenever i run use Collections.sort it will directly call Comparable
    @Override
    public int compareTo(Employee e) {
        int firstCompare=this.fname.compareTo(e.fname);
        if(firstCompare!=0){
            return firstCompare;
        }
        return this.lname.compareTo(e.lname);
    }
}
public class Ques2 {
    static void main(String[] args) {
        List<Employee> e1=new ArrayList<>();//creating a list of Employee Objects
        //here we have created an instance variable of Wrapper Class hence we have to create a object instead of passing primitive data
        e1.add(new Employee(Double.valueOf(23),Double.valueOf(40000),"Ram","Kumar"));
        e1.add(new Employee(Double.valueOf(24),Double.valueOf(15000),"Dhruv","Baghel"));
        e1.add(new Employee(Double.valueOf(22),Double.valueOf(27000),"Raj","Kapoor"));
        e1.add(new Employee(Double.valueOf(21),Double.valueOf(25000),"Kanika","Sharma"));
        //Sorting by firstName and lastName by implicitly calling Comparable
        Collections.sort(e1);
        System.out.println("Sorted by First Name and Last Name:");
        e1.forEach(System.out::println);

        // Sorting by Salary by passing an object of SalaryComparator
        Collections.sort(e1, new SalaryComparator());
        System.out.println("Sorted by Salary:");
        e1.forEach(System.out::println);
    }
}
