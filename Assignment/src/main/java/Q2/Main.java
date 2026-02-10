package Q2;

import Q2.ImplementationClasses.SimpleCalculator;
import Q2.abstraction.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calc=new SimpleCalculator();
        Ques2 q1=new Ques2(calc);
        System.out.println(q1.addNumbers(5,6));
    }
}
