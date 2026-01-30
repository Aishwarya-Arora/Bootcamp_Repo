package Multithreading;


import java.util.Random;
import java.util.concurrent.*;

//this class is implementing callable and it return generic
class RandomNumberTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random random = new Random(); //creating a random object
        int number = random.nextInt(100); //generates a random no between 0 to 99
        System.out.println(Thread.currentThread().getName()
                + " generated number: " + number);
        return number;
    }
}
public class Ques8 {
    static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();  //creates only one worker thread and it will execute submitted tasks one at a yime

        // submit Callable task which is returning a random number and it is submitted to Future object
        Future<Integer> future = executor.submit(new RandomNumberTask());

        // get result
        Integer result = future.get();

        System.out.println("Random number received from thread :- " + result);

        executor.shutdown();//Allows current task to finish
    }
}
