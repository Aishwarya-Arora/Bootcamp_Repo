package NewPack;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Ques6 {

    public static void main(String[] args) {
        //Each object owns its own lock
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();

        Thread t1 = new Thread(() -> {
            orderService.processOrder(paymentService);
        }, "Order-Thread");

        Thread t2 = new Thread(() -> {
            paymentService.processPayment(orderService);
        }, "Payment-Thread");
        //starting two objects concurrently
        t1.start();
        t2.start();
    }
}



class OrderService {

    // Explicit lock instead of implicit synchronized lock
    private final ReentrantLock orderLock = new ReentrantLock();

    public void processOrder(PaymentService paymentService) {
        while (true) {
            try {
                // Try acquiring Order lock waits for 1 second.Returns true if lock acquired, false otherwise
                if (orderLock.tryLock(1, TimeUnit.SECONDS)) {
                    try {
                        System.out.println(Thread.currentThread().getName()
                                + " acquired Order lock");

                        Thread.sleep(50);

                        // Try acquiring Payment lock safely
                        if (paymentService.tryProcessPayment(this)) {
                            break; // successful, exit loop
                        }
                    } finally {
                        orderLock.unlock();
                        System.out.println(Thread.currentThread().getName()
                                + " released Order lock");
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public boolean tryUpdateOrderStatus()
            throws InterruptedException {

        if (orderLock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                System.out.println(Thread.currentThread().getName()
                        + " updated order status");
                return true;
            } finally {
                orderLock.unlock();
            }
        }
        return false;
    }
}


class PaymentService {

    private final ReentrantLock paymentLock = new ReentrantLock();

    public void processPayment(OrderService orderService) {
        while (true) {
            try {
                if (paymentLock.tryLock(1, TimeUnit.SECONDS)) {
                    try {
                        System.out.println(Thread.currentThread().getName()
                                + " acquired Payment lock");

                        Thread.sleep(50);

                        if (orderService.tryUpdateOrderStatus()) {
                            break; // successful
                        }
                    } finally {
                        paymentLock.unlock();
                        System.out.println(Thread.currentThread().getName()
                                + " released Payment lock");
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public boolean tryProcessPayment(OrderService orderService)
            throws InterruptedException {

        if (paymentLock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                System.out.println(Thread.currentThread().getName()
                        + " processing payment");
                return orderService.tryUpdateOrderStatus();
            } finally {
                paymentLock.unlock();
            }
        }
        return false;
    }
}

