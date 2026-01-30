package Multithreading;

import java.util.concurrent.*;

// Runnable can only perform a task but cannot return a value
class RunnableTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable thread is running");
    }
}

// Callable can return a value and throw checked exceptions
class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable thread is running");
        return 1;
    }
}

public class Ques5 {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {

        // Executor with fixed number of threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Executing runnable task (no return value)
        Runnable runnableTask = new RunnableTask();
        executor.execute(runnableTask);//it will add a task to executor task queue

        // Submitting Callable task (returns a value)
        Callable<Integer> callableTask = new MyCallable();
        Future<Integer> future = executor.submit(callableTask);

        // Getting the result returned by Callable
        // This call blocks until the Callable finishes execution
        Integer result = future.get();
        System.out.println("Result from Callable: " + result);

        // Properly shutting down the executor
        executor.shutdown();
    }
}
