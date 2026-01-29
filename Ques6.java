package Java8;

interface Calculator{
    int subtract(int a,int b);  //abstract method
    default int add(int a,int b){   //default method
        return a+b;
    }
    static int multiply(int a,int b){       //static method
        return a*b;
    }
}
class CalculatorOperations implements Calculator{
    @Override
    public int subtract(int a,int b){   //overriding the abstract method
        return a-b;
    }
}
public class Ques6 {
    static void main(String[] args) {
        CalculatorOperations c1=new CalculatorOperations();
        System.out.println("Adding :- "+c1.add(2,4));
        System.out.println("Subtracting :- "+c1.subtract(6,2));
        System.out.println("Multiplying :- "+Calculator.multiply(5,6));
    }
}
