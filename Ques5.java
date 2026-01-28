package SelfStudy1;

class Employee{
    private int age;
    private String firstname;
    private String lastName;
    private String designation;
    //non parameterized constructor
    Employee(){
        age=24;
        firstname="Aishwarya";
        lastName="Arora";
        designation="Trainee";
    }
    //parameterized constructor
    Employee(String firstname,String lastName,String designation,int age){
        this.firstname=firstname;
        this.lastName=lastName;
        this.designation=designation;
        this.age=age;
    }
    //copy constructor
    Employee(Employee e){
        this.firstname=e.firstname;
        this.lastName=e.lastName;
        this.designation=e.designation;
        this.age=e.age;
    }
    //setter methods
    //these methods are used to set a particular private field
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    public void  setLastName(String lastName){
        this.lastName=lastName;
    }
    public void  setAge(int age){
        this.age=age;
    }
    public void setDesignation(String designation){
        this.designation=designation;
    }
    //tostring method is called each time whenever you try to print a object
    @Override
    public String toString() {
        return "firstname :-"+firstname+"\nlastname :-"+lastName+"\ndesignation :-"+designation+"\nage :-"+age;
    }
}
public class Ques5 {
    static void main(String[] args) {
        Employee e=new Employee(); //now the nonparameterized will be called instead of bydefault
        //if we don't initialize any constructor then it will call the bydefault constructor which JVM uses to initialize the instance variables with default values
//        System.out.println(e.firstname+" "+e.lastName+" "+e.age+" "+e.designation);
        System.out.println("Non Parameterized Constructor :-");
        System.out.println(e);
        System.out.println("Calling the setter methods");
        e.setFirstname("Neelam");
        e.setLastName("Kapoor");
        e.setDesignation("Senior Software Developer");
        e.setAge(30);
        System.out.println(e);
        Employee e1=new Employee("Mahika","Arora","Manager",30);
        System.out.println("Parameterized Constructor :-");
        System.out.println(e1);
        Employee e2=new Employee(e1);
        System.out.println("Copy Constructor :-");
        System.out.println(e2);
    }
}
