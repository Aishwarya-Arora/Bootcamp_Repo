package SelfStudy1;

public class Ques8 {
    static void main(String[] args) {
        try{
            //Class.forName use to dynamically load at runtime
            Class.forName("hello.first");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
}
