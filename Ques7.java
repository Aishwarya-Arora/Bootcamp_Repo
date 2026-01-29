package Java8;

import java.util.Arrays;

public class Ques7 {
    static void main(String[] args) {
        //first of all since we need a list so i created a list using Arrays.asList() and then converting this list into a stream since only on stream we can apply filter method after that to calculate the sum sum() performs on primitive method so converting it using maptoint method and then calculating sum using sum() method
        int i1= Arrays.asList(1,2,3,4,5,6,7).stream().filter(num->num>5).mapToInt(Integer::intValue).sum();

        System.out.println(i1);
    }
}
