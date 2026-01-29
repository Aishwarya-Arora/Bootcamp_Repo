package Java8;

interface Doctor{
    default void work(){      //interface having default method
        System.out.println("Doctor perform operations");    //default methods are those methods in which we can pass body in a interface and when it is implemented by a class we can either  override a method or use this defination only
    }
}
interface Engineer{
   default void work(){         //Engineer have a different work definition
       System.out.println("Engineer work on different projects");
   }
}
class  Person implements Doctor,Engineer{           //this class implements both hence will have two work methods so we can override the default method and tell whose work we want
    @Override
    public void work(){
        Engineer.super.work();  //calling the engineer interface work
    }
}
public class Ques3 {
    static void main(String[] args) {
        Person p1=new Person(); //creating a object
        p1.work(); //calling the work method
    }
}
