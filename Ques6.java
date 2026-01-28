package SelfStudy1;

class Bank{
    private String name;
    private String headOfficeAddress;
    private String chairmanName;
    private int branchCount;
    private double fdInterestRate;
    private double personalLoanInterestRate;
    private double homeLoanInterestRate;

    //getters and setters method
    public void setBranchCount(int branchCount) {
        this.branchCount = branchCount;
    }

    public void setChairmanName(String chairmanName) {
        this.chairmanName = chairmanName;
    }

    public void setFdInterestRate(double fdInterestRate) {
        this.fdInterestRate = fdInterestRate;
    }

    public void setHeadOfficeAddress(String headOfficeAddress) {
        this.headOfficeAddress = headOfficeAddress;
    }

    public void setHomeLoanInterestRate(double homeLoanInterestRate) {
        this.homeLoanInterestRate = homeLoanInterestRate;
    }

    public void setPersonalLoanInterestRate(double personalLoanInterestRate) {
        this.personalLoanInterestRate = personalLoanInterestRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBranchCount() {
        return branchCount;
    }

    public double getFdInterestRate() {
        return fdInterestRate;
    }

    public double getHomeLoanInterestRate() {
        return homeLoanInterestRate;
    }

    public double getPersonalLoanInterestRate() {
        return personalLoanInterestRate;
    }

    public String getChairmanName() {
        return chairmanName;
    }

    public String getHeadOfficeAddress() {
        return headOfficeAddress;
    }

    public String getName() {
        return name;
    }

    //overriding toString method so that we will be able to print the directly
    @Override
    public String toString() {
        return "SelfStudy1.Bank name :-" + name +
                "\nHeadoffice :-" + headOfficeAddress +
                "\nChairman :-" + chairmanName +
                "\nBranch Count :-" + branchCount +
                "\nFD Interest Rate :-"+fdInterestRate+"%"+
                "\nPersonal Loan Interest Rate :-"+personalLoanInterestRate+"%"+
                "\nHome Loan Interest Rate :-"+homeLoanInterestRate+"%";
    }
}
//Only the public protected and default fields and method are inherited
class SBI extends Bank{         //Subclass SelfStudy1.SBI

}
class BOI extends Bank{         //Subclass SelfStudy1.BOI

}
class ICICI extends Bank{       //Subclass SelfStudy1.ICICI

}
public class Ques6 {
    static void main(String[] args) {
        SBI sbi=new SBI(); //creating the sbi object
        sbi.setName("State SelfStudy1.Bank of India");
        sbi.setBranchCount(200);
        sbi.setChairmanName("Anil Kumar");
        sbi.setHeadOfficeAddress("Mumbai");
        sbi.setFdInterestRate(6.3);
        sbi.setHomeLoanInterestRate(5);
        sbi.setPersonalLoanInterestRate(4);

        //printing the value by directly using writing the refernce variable inside the println statement
        System.out.println(sbi);
        System.out.println("-------------------------");
        BOI boi=new BOI(); //creating bou object
        boi.setName("SelfStudy1.Bank of India");
        boi.setChairmanName("Ram Kumar");
        boi.setBranchCount(300);
        boi.setFdInterestRate(7);
        boi.setHeadOfficeAddress("Mumbai");
        boi.setHomeLoanInterestRate(8);
        boi.setPersonalLoanInterestRate(6.5);

        System.out.println(boi); //calling the toString method for boi object
        System.out.println("-------------------------");
        ICICI icici=new ICICI(); //creating the icici object
        icici.setName("SelfStudy1.ICICI SelfStudy1.Bank");
        icici.setBranchCount(700);
        icici.setChairmanName("Rajeev Gupta");
        icici.setHeadOfficeAddress("Mumbai");
        icici.setFdInterestRate(9);
        icici.setPersonalLoanInterestRate(4);
        icici.setHomeLoanInterestRate(5.7);

        System.out.println(icici); //calling the toString method for icici object
    }
}
