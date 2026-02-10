package Q2.ImplementationClasses;

import Q2.abstraction.Calculator;


//to show the loose coupling implementing the interface by the class
public class ScientificCalculator implements Calculator {
    @Override
    public int add(int a, int b) {
        System.out.println("Scientific Calculator");
        return a+b;
    }
}
