package SelfStudy2;
class Singleton {
    //Singleton Design Pattern is used whenever we want to create a single object only.
    // private static instance
    private static Singleton instance;

    // private constructor which is used to create Singleton
    private Singleton() {
        System.out.println("Singleton instance created");
    }

    // public static method to get instance which we will call whenever we want to initialize a object
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); //it is used to create the object once if it is null
        }
        return instance; //returning the instance if not null
    }
}

public class Ques5 {
    static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);  // since we are only creating the object once so we will get the same refernce of the object
    }
}
