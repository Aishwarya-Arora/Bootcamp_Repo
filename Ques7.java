package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SimpleTask implements Runnable {

    private final int taskId;

    SimpleTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " executing task " + taskId);
        try {
            Thread.sleep(1000); // simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Ques7 {
    public static void main(String[] args) throws InterruptedException {

        // Create a list of tasks
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            tasks.add(new SimpleTask(i));
        }
            //it will create only one thread execute task one by one
        System.out.println("Using SingleThreadExecutor");
        runTasks(Executors.newSingleThreadExecutor(), tasks);
            //exactly 2 threads at a time remaining will wait in a queue
        System.out.println(" Using FixedThreadPool");
        runTasks(Executors.newFixedThreadPool(2), tasks);
            //creates thread as needed.It reuses idle thread
        System.out.println(" Using CachedThreadPool ");
        runTasks(Executors.newCachedThreadPool(), tasks);
    }

    // Method to submit tasks and wait for completion
    private static void runTasks(ExecutorService executor,
                                 List<Runnable> tasks)
            throws InterruptedException {

        // Submit all tasks
        for (Runnable task : tasks) {
            executor.execute(task);
        }

        // Stop accepting new tasks
        executor.shutdown();

        // Wait for all tasks to finish
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("All tasks completed.");
    }
}
