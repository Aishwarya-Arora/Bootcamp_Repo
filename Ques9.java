package SelfStudy1;
class NewException extends Exception{
    public NewException(String msg){
        //It will call the Exception Class Constructor
        super(msg);
    }
    public synchronized Throwable fillInStackTrace(){
        return this;
    }
}
public class Ques9 {
    static void main(String[] args) {
        try{
            throw new NewException("This message I want to be printed..");
        }catch(NewException e){
            e.printStackTrace();
        }
    }
}
