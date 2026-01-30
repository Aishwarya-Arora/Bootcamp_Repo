package Multithreading;


public class Ques4Deadlock {


    public static void main(String[] args) throws InterruptedException {


        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();


        // Thread-1 starts order processing and since it is also calling another method
        Thread t1 = new Thread(() -> {
            orderService.processOrder(paymentService);
        }, "Order-Thread");


        // Thread-2 starts payment which is dependent on orderService so both are acquiring locks and wants to another lock but it is taken by some other thread
        Thread t2 = new Thread(() -> {
            paymentService.processPayment(orderService);
        }, "Payment-Thread");


        t1.start();
        t2.start();


        // Program will hang here due to deadlock
        t1.join();
        t2.join();
    }
}


class OrderService {
    //Each object has a implicit lock
    private final Object orderLock = new Object();




    public void processOrder(PaymentService paymentService) {
        synchronized (orderLock) {
            // a lock is aquired by a thread
            System.out.println(Thread.currentThread().getName() + " acquired Order lock");


            // Small delay to increase deadlock probability
            sleep();


            // calls another method that tries to acquire Payment lock
            paymentService.processPayment(this);
        }
    }




    public void updateOrderStatus() {
        synchronized (orderLock) {
            System.out.println(Thread.currentThread().getName()
                    + " updated order status");
        }
    }






    private void sleep() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


class PaymentService {


    private final Object paymentLock = new Object();




    public void processPayment(OrderService orderService) {
        synchronized (paymentLock) {
            System.out.println(Thread.currentThread().getName()
                    + " acquired Payment lock");


            sleep();   //sleeping for 50 ms


            // Calls another method that tries to acquire Order lock
            orderService.updateOrderStatus();
        }
    }



    private void sleep() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
