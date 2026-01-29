package Java8;

import java.util.Optional;

class Person1 {
    private String name;
    private String email; // may be null

    Person1(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}


//Optional is used to check nullpointerexception and make our code more secure
public class Ques8 {

    //checking whether the object is empty or not
    static Optional<String> getPersonEmail(Person1 p1) {
        return Optional.ofNullable(p1.getEmail());  //it returns an optional object which will tell whether the object is empty or not if empty then return empty()
    }
    static void main(String[] args) {
        Person1 e1 = new Person1("Aishwarya", "aishwarya@gmail.com");
        Person1 e2 = new Person1("Rahul", null);

        // Case 1: Email present
        String email1 = getPersonEmail(e1)
                .orElse("Email not available");
        System.out.println(email1);

        // Case 2: Email absent
        String email2 = getPersonEmail(e2)
                .orElse("Email not available");
        System.out.println(email2);
    }
}
