package Multithreading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class LongRunningTask implements Runnable {

    private final int taskId;
    //creating a taskId so that we can see which task is running
    LongRunningTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " started task " + taskId);

            Thread.sleep(5000); //making the thread to sleep for 5 sec to simulate long task

            System.out.println(Thread.currentThread().getName() + " completed task " + taskId);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()
                    + " interrupted while executing task " + taskId);  //whenever we use shutdownnow() it print the interruptedException
        }
    }
}

public class Ques9 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);  //creating a thread pool of size 2 so that atmost 2 task can run at the same time

        for (int i = 1; i <= 4; i++) {
            executor.submit(new LongRunningTask(i));  //4 tasks are submitted but only 2 will start running remaining 2 will be in queue
        }

        Thread.sleep(2000); // allow tasks to start

        System.out.println("Calling shutdownNow");
        executor.shutdownNow();   // it interrupts all the running threads and stop accepting task remove all the tasks from the queue
        //executor.shutdown();  //it will compelete the task rather than just interrupting
    }
}
