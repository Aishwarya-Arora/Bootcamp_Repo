package Q1;


//Example to show Tightly coupling
public class Ques1 {
    private int age;
    private String name;
    //Ques1 is dependent on Address class any change in Address class we have to make in the Ques1 class
    Address address =new Address(110032,"Delhi");
    Ques1(int age,String name){
        this.age=age;
        this.name=name;
    }

    //to string method
    @Override
    public String toString() {
        return name+" | "+age+" | "+address.getPincode()+" | "+address.getCity();
    }
}
