package Java8;
//functional interface having one abstract method
@FunctionalInterface
interface Calculation{
    public int operate(int a,int b);
}
//class having add subtract and multiply methods
class Operation{
    public int add(int a,int b){
        return a+b;
    }
    public int subtract(int a,int b){
        return a-b;
    }
    public static int multiply(int a,int b){
        return a*b;
    }
}
public class Ques2 {
    static void main(String[] args) {
    Operation op=new Operation(); //creating a object of class
    Calculation cal=op::add; //Creating a reference variable of Calculation interface and passing the implementation of add function to the operate function since add is not a static methos we have it use the reference variable
    System.out.println("Add functionality :-"+cal.operate(4,5)); //calling the interface method using the object
    cal=op::subtract;
    System.out.println("Subtract functionality :-"+cal.operate(4,5));
    cal=Operation::multiply; //Since the multiply is static we use Classname before scope resolution(::)
    System.out.println("Muliply functionality :-"+cal.operate(4,5));
    }
}
