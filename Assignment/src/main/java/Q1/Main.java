package Q1;


//Main class is used to create a dependent object
public class Main {
    public static void main(String[] args) {

        //It is already showing Tightly coupled Main class is tightly coupled with Ques1 but to show more i have created another class Ques1
        Ques1 q1=new Ques1(12,"NAME");
        System.out.println(q1);
    }
}
