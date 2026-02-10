package Q2.ImplementationClasses;

import Q2.abstraction.Calculator;

public class ScientificCalculator implements Calculator {
    @Override
    public int add(int a, int b) {
        System.out.println("Scientific Calculator");
        return a+b;
    }
}
