package SelfStudy1;

class Person{
    static String firstName;
    static String lastname;
    static int age;
    //creating a static block inorder to print the values;
    static{
        firstName="Aishwarya";
        lastname="Arora";
        age=24;
        System.out.println("Inside the static Block "+firstName+" "+lastname+" "+age);
    }
    static void print(String fname,String lname,int age1){
        //creating static method can only make access the static variables and methods
        firstName=fname;
        lastname=lname;
        age=age1;
        System.out.println("Inside the static Method "+firstName+" "+lastname+" "+age);
    }
}

class Main{
    public static void main(String[] args){
        //here since we have created a static method it can be called directly without creating a object
        Person.print("Rahul","Arora",22);
        //similarly we can access static variables using classname no need to create an object
        Person.firstName="Mahika";
        Person.lastname="Arora";
        Person.age=18;
        System.out.println("Inside the main block "+Person.firstName+" "+Person.lastname+" "+ Person.age);
    }
}