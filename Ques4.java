package Java8;

//creating a class Employee
class Employee{
    private String name;
    private int age;
    Employee(String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Name :- "+name+" | Age :- "+age;
    }
}

@FunctionalInterface
interface EmployeeMethod{
    Employee createMethod(String name,int age);
}
public class Ques4 {
    static void main(String[] args) {
        //Constructor reference is a special type of reference which will refer to a constructor without calling it
        EmployeeMethod em=Employee::new;        // Creating a reference variable of functional interface and passing the constructor reference to the interface method
        Employee e1=em.createMethod("Aishwarya",23); //calling it using the interface method
        Employee e2=em.createMethod("Rahul",21);
        System.out.println(e1);
        System.out.println(e2);
    }
}
