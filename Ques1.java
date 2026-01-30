package Multithreading;

//Runnable is a interface which is implemented by a class
class MyRunnable implements Runnable {

    //In run method we can write the task
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {      //loop woll run three times
                System.out.println(Thread.currentThread().getName()
                        + " - Runnable thread count: " + i);
                Thread.sleep(1000); // sleep for 1 second and it also throws Interrupted exception
            }
        } catch (InterruptedException e) {
            System.out.println("Runnable thread interrupted");
        }
    }
}

//Thread is a class which we can extend to create thread
class MyThread extends Thread {

    //run method to define the task
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName()
                        + " - Thread class count: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}

public class Ques1 {
    static void main(String[] args) throws InterruptedException {
        //Creating the thread through Runnable interface
        Thread t1 = new Thread(new MyRunnable(), "Runnable-Thread");

        // Creating thread using Thread class
        MyThread t2 = new MyThread();
        t2.setName("Thread-Class-Thread");

        t1.start();   // starting Runnable thread
        t1.join();    //main thread will wait for t1 to get compeleted

        t2.start();   // starting Thread class thread
        t2.join();    // main thread waits for t2 to finish

        System.out.println("Main thread finished execution");
    }

}
