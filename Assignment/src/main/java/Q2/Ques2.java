package Q2;

import Q2.abstraction.Calculator;

public class Ques2 {
   private Calculator calc;
    Ques2(Calculator calc){
        this.calc=calc;
    }
    public int addNumbers(int a,int b){
        return calc.add(a,b);
    }
}
