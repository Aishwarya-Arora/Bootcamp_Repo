package Multithreading;


class CounterBlock {

    private int count = 0;

    public void increment() {

        // synchronized block is used whenever we want only some part of method to be access by a single thread at a time
        synchronized(this) { //giving this in synchronized to refer the current thread
            count++;
            System.out.println(Thread.currentThread().getName() + " - Count :- " + count);
        }
    }
}

class MyBlockThread extends Thread {

    CounterBlock counter;

    MyBlockThread(CounterBlock counter){
        this.counter=counter;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            counter.increment();
        }
    }
}

public class Ques2b {

    static void main(String[] args) {
        CounterBlock counter = new CounterBlock();  //shared object

        MyBlockThread t1 = new MyBlockThread(counter); //passing the reference of object in the thread in order to call the increment method
        MyBlockThread t2 = new MyBlockThread(counter);

        t1.setName("ThreadA");
        t2.setName("ThreadB");

        t1.start();
        t2.start();
    }

}
