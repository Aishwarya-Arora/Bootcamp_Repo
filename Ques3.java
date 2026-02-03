import java.util.ArrayList;
import java.util.List;

public class Ques3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(36);
        list.add(25);
        list.add(65);
        list.add(12);

        // toList method here used to create immutable list
        List<Integer> ans=  list.stream().map(e -> e+1) . toList();

        System.out.println(ans);
        ans.add(50);
        //here we are trying to add a object in the list which is not possible
        System.out.println(ans);
    }

}