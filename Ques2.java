package Multithreading;

class Counter {

    private int count = 0;

    // synchronized method will allow data consistency like only one thread will access a shared resource at one time
    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " - Count :- " + count); //printing the thread name and count variable
    }
}

class Thread1 extends Thread {

    Counter counter;        //here creating a counter reference so that we can call the increment method

    Thread1(Counter counter) {
        this.counter = counter;         //passsing the shared object to  the counter reference means giving the same memory address
    }

    //in run method we can call the shared resource
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            counter.increment();
        }
    }
}
public class Ques2 {
    static void main(String[] args) {
        Counter counter = new Counter(); // shared object which is used by every thread which is used to call shared method

        //creating 3 threads
        Thread1 t1 = new Thread1(counter);
        Thread1 t2 = new Thread1(counter);
        Thread1 t3 = new Thread1(counter);

        //setting the names for threads
        t1.setName("Thread1");
        t2.setName("Thread2");
        t3.setName("Thread3");


        //starting the thread
        t1.start();
        t2.start();
        t3.start();
    }
}
