package SelfStudy1;

public class Ques7 {
    static void main(String[] args) {
        try{ //try block
            int[] arr={0,1,2};
            int a=10,b=0;
            int c=a/b; //Arithmetic Exception
            System.out.println(arr[4]); //IndexoutofBoundException
        }catch(ArithmeticException | IndexOutOfBoundsException e){
            //catch block
            System.out.println(e);
        }finally{
            //finally block
            System.out.println("This is a finally block...");
        }
    }

}
