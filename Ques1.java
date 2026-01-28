package SelfStudy2;
//enum is one of the way to define constants in java.Enum is just like a class.
enum House{
    //constants
     ONE_BHK(2500000),
      TWO_BHK(4500000),
      THREE_BHK(6500000),
      VILLA(12000000);
     //instance variable
    private final int price;
    //constructor
    House(int price){
        this.price=price;
    }
    //getter
    public int getPrice() {
        return price;
    }
}
public class Ques1 {
    public static void main(String[] args) {
    //iterating over the constants value
        //Each Enum stores its own price which is accessed by the getter method and displayed by iterating over the House.values()
        for (House h : House.values()) {
            System.out.println(h + " price is: " + h.getPrice());
        }
    }
}
