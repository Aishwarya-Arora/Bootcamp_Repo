package SelfStudy1;
class Random{
    static {
        //making a static block so that we are making the class Random not loaded Properly.
            int a=10;
            int b=0;
            int c=a/b;
    }

}
public class Ques8b {
    static void main(String[] args) {
        try{
            //making the object so that static block can be loaded first
            Random r=new Random();
        }catch(Throwable t){
            //now since the static block is throwing a Arithmetic Exceptiom..
            System.out.println("Arithmetic Exception is handled");
        }
        //now since the class is not loaded properly by the JVM it will throw the NoClassDefFoundError.
        new Random();
    }
}
