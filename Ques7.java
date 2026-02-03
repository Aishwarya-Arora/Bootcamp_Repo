import java.util.List;
import java.util.stream.Stream;

public class Ques7 {
    public static void main(String[] args) {
        List<Integer> list = Stream.iterate(0, i-> i<=100, i-> i+1).toList();
        //it is used to create a unmodifiable list.
        System.out.println(list);
     }
}