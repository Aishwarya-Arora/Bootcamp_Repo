package Multithreading;

//with the help of volatile keyword we can maintain data consistency and keep reflecting the changes.
class SharedData {
    volatile boolean running = true;  // volatile variable
}

class WorkerThread extends Thread {

    SharedData data;

    WorkerThread(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("Worker thread started");

        while (data.running) {
            // keeps checking updated value but if the running is not false this will keep running
        }
        //this statement will never get executed if we don't use volatile keyword
        System.out.println("Worker thread stopped");
    }
}

public class Ques3 {

    static void main(String[] args)  throws InterruptedException{
        SharedData data = new SharedData();
        WorkerThread t1 = new WorkerThread(data);

        t1.start();

        Thread.sleep(2000); // main thread sleeps for 2 sec

        System.out.println("Main thread changing flag");
        data.running = false;   //making the volatile keyword false so that we can come out of while loop
    }
}
