package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ques1 {
    static void main(String[] args) {
        //creating a list we have used reference variable of list interface but we can also use reference variable of ArrayList,LinkedList
        List<Float> al=new ArrayList<>();
        //to add a element in a list we have a add() method in list interface whose implememtation is written in ArrayList and LinkedList
        al.add(1.5f);
        al.add(9.5f);
        al.add(4.9f);
        al.add(3.2f);
        al.add(0.5f);
        System.out.println(al);
        //to iterate over the collections we use iterator method
        Iterator<Float> itr=al.iterator();
        float sum=0.0f;
        while (itr.hasNext()){
            sum+= itr.next();
        }
        System.out.println(sum);
    }
}
