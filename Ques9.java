
import java.util.Objects;
//a record is just a type of special class
record student(int id, String name, String standard) {

    public student {

        //this is specifying that name and standard cannot be null if it is null then store message specified
        Objects.requireNonNull(name, "name cannot be null");
        Objects.requireNonNull(standard, "standard cannot be null");
    }
}

public class Ques9 {
    public static void main(String[] args) {

        student s1 = new student(1, "Aishwarya", "10th");
        student s2 = new student(1, "Aishwarya", "10th");

        System.out.println(s1.equals(s2));      
        System.out.println(s1.hashCode() == s2.hashCode()); 
    }
}