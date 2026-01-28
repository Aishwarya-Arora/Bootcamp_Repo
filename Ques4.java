package Collections;

import java.util.HashMap;
import java.util.Map;

class Employee1{
    private String name;
    private Integer age;
    private String designation;
    private Double salary;
    //parameterized constructor
    Employee1(String name,Integer age,String designation,Double salary){
        this.name=name;
        this.age=age;
        this.designation=designation;
        this.salary=salary;
    }
    //getters
    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public Integer getAge() {
        return age;
    }

    public String getDesignation() {
        return designation;
    }
    //overriding the toString inorder to print the object
    @Override
    public String toString(){
        return  this.name+" "+this.designation+" "+this.age;
    }
}
public class Ques4 {
    static void main(String[] args) {
        //Creating a hashmap which is used to map the key with the values
        HashMap<Employee1,Double> h1=new HashMap<>();
        //since we have used Wrapper Classes so convert the primitive number into Object by using valueOf
        Employee1 e1=new Employee1("Aishwarya",24,"Trainee",Double.valueOf(15000));
        Employee1 e2=new Employee1("Kanika",28,"Manager",Double.valueOf(24000));
        Employee1 e3=new Employee1("Raj",35,"CEO",Double.valueOf(100000));
        Employee1 e4=new Employee1("Mahika",26,"Tech Lead",Double.valueOf(50000));
        //adding the values to the hashmap using put
        h1.put(e1,e1.getSalary());
        h1.put(e2,e2.getSalary());
        h1.put(e3, e3.getSalary());
        h1.put(e4,e4.getSalary());
        //now iterating over the hashmap using the hashmap_object.entrySet()
        for (Map.Entry<Employee1, Double> entry : h1.entrySet()) {
            System.out.println(entry.getKey() + " | Salary: " + entry.getValue());
        }
    }
}
