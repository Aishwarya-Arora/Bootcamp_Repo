package Q1;

//Address class is a independent class having getter and setters
public  class Address {
    private int pincode;
    private String city;
    Address(int pincode,String city){
        this.pincode=pincode;
        this.city=city;
    }

    public String getCity() {
        return city;
    }

    public int getPincode() {
        return pincode;
    }
}
