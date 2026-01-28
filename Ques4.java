package SelfStudy1;

import java.util.Scanner;
public class Ques4 {
    static void main(String[] args) {
        int[][] twod=new int[3][3];
        Scanner sc=new Scanner(System.in);
        //Taking the input from user
        for(int i=0;i<twod.length;i++){
            for(int j=0;j<twod[i].length;j++){
                twod[i][j]=sc.nextInt();
            }
        }
        //Displaying the 2 D array
        for(int i=0;i< twod.length;i++){
            for(int j=0;j<twod[i].length;j++){
                System.out.print(twod[i][j]+" ");
            }
            System.out.println();
        }
        //now calculating the sum for each row and column

        //calculating for row first
        int sumRow=0;
        for(int i=0;i<twod.length;i++){
            for(int j=0;j<twod[i].length;j++){
                sumRow+=twod[i][j]; //here we are adding each row value to the sumRow variable
            }
            System.out.println("Sum of "+i+" Row :- "+sumRow);
            sumRow=0; // after iterating for a row we don't want the sum to have sum initial value for another row that's why making it 0
        }
        int sumCol=0;
        for(int i=0;i< twod.length;i++){
            for(int j=0;j<twod[i].length;j++){
                sumCol+=twod[j][i];//here i have used [j][i] because i want to calculate it for column and in column we can see 00 10 20 so inorder to increase the first index we used j in the start as we are iterating j for each i
            }
            System.out.println("Sum of "+i+" Column :- "+sumCol);
            sumCol=0; //making it also 0 so that i can get the value for single column
        }
    }
}
