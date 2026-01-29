package Java8;

//A functional interface which has only one abstract method we can use the annotation @functionalInterface which is recommended to use.

//Lambda Expression is used in making the code cleaner ,simple and more readable
@FunctionalInterface
interface Greater{
    boolean isgreater(int a,int b);         //functional interface having greater functiom
}

@FunctionalInterface
interface Increment{
    int incrementByOne(int a);              //functional interface having greater functiom
}

@FunctionalInterface
interface ConcatenateString{
    String concatenate(String s1,String s2);    //functional interface having concatenate function
}

@FunctionalInterface
interface UpperCase{
    String toUpperCase(String s1);              //functionsal interface having uppercase function
}
public class Ques1 {
    static void main(String[] args) {
        Greater greater=(a,b)->a>b;     //A object of Interface with the help of which we can call the isgreater function
        System.out.println("Checking whether a number is greater or not :-"+greater.isgreater(5,6));

        Increment increment=(a)->a+1;       //Similarly defining the function by lambda function
        System.out.println("Incrementing a number by one"+increment.incrementByOne(7));

        String s3="Hello";
        String s4="World";
        ConcatenateString con=(s1,s2)->s1.concat(s2);   //defining the concat function here
        System.out.println("Concatenate two strings "+con.concatenate(s3,s4));

        UpperCase up=(s1)->s1.toUpperCase();            //defining the uppercase function using lambda Expression
        System.out.println("UpperCasing a string "+up.toUpperCase(s3));
    }
}
