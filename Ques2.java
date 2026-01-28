package SelfStudy1;//inorder to take input we can import Scanner class from java.util package
import java.util.Scanner;
public class Ques2 {
    static void main(String[] args) {
        //creating a object of scanner class to take the input
        Scanner sc=new Scanner(System.in);
        //to store the input we have initialized the output and input is used to collect all the input give by the user
        String input="",output;
        do{
            output=sc.nextLine();
            if(!output.equals("XDONE")){
                //appending all the output taken to the input variable
                input+=output+"\n";
            }else{
                //here since the do while loop will exceute infinitely so inorder to terminate i have used break if the user input is XDONE
                break;
            }
        }while(true);
        System.out.println(input);
    }
}
