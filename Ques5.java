package Java8;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ques5 {
    static void main(String[] args) {

        //All the supplier,consumer,predicate,function are functional interface
        //Consumer will take the input and return nothing
        Consumer<String> c1=name->System.out.println("Hey this is "+name);
        c1.accept("Aishwarya Arora");  //it has a method accept using which we can give the input

        //Supplier interface will take nothing and return a value
        Supplier<Employee> s1=()->new Employee("Aishwarya",24);
        System.out.println(s1.get());   //get method will return a output

        //Predicate interface will take a input and return boolean
        Predicate<Integer> p1=num->num>5;
        System.out.println(p1.test(5));     //test method will take a value and return whether the condition specified is true or not
        System.out.println(p1.test(7));

        //function interface will transform input and give output
        Function<Integer,Integer> f1=num->num*4;
        System.out.println(f1.apply(5));    //apply method will give the transformed output
    }
}
