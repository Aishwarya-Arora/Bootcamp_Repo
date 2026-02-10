package Q2.ImplementationClasses;

import Q2.abstraction.Calculator;

public class SimpleCalculator implements Calculator {

    @Override
    public int add(int a, int b) {
        System.out.println("Simple Calculator");
        return a+b;
    }
}
