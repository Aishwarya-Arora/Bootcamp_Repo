package SelfStudy1;

import java.util.Scanner;
public class Ques3 {
    static void main(String[] args) {
        //initalizing the scanner object
        Scanner sc=new Scanner(System.in);
        int ch;
        do{
            System.out.println("**********MENU************");
            System.out.println("1.Area of circle");
            System.out.println("2.Circumference of circle");
            System.out.println("3.Exit");
            //input the choice of user
            System.out.print("Enter your choice :-");
            ch=sc.nextInt();
            double radius;
            //using switch case to write the logic matching the user choice
            switch(ch){
                case 1:
                    //Logic for Area
                    System.out.print("Enter the radius :-");
                    radius=sc.nextDouble();
                    double area=Math.PI*radius*radius;
                    System.out.println("Area is :-"+area);
                    break;
                case 2:
                    //Logic for Circumfernece
                    System.out.print("Enter the radius :-");
                    radius= sc.nextDouble();
                    double circumference=Math.PI*2*radius;
                    System.out.println("Circumference is :-"+circumference);
                    break;
                case 3:
                    System.out.println("Exiting from menu...");
            }
            //here i want that the menu will keep displaying until the user does not enter 3
        }while(ch!=3);
    }
}
