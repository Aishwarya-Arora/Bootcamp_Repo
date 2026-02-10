package Q1;

public class Ques1 {
    private int age;
    private String name;
    Address address =new Address(110032,"Delhi");
    Ques1(int age,String name){
        this.age=age;
        this.name=name;
    }

    @Override
    public String toString() {
        return name+" | "+age+" | "+address.getPincode()+" | "+address.getCity();
    }
}
