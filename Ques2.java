import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
Use Of method to create List, Set and Map
 */
public class Ques2 {
    public static void main(String[] args) {

        List<Integer> list = List.of(10,20,54,32,12,45,54);
        Set<Integer> set = Set.of(10,25,32,65,24);
        Map<Integer,String>  map = Map.of(1,"Aishwarya",2,"Ram");

        //trying to modify it is not possible we can just create a list set and map using .of which is unmodifiable
        map.put(3,"Harish");



    }

}