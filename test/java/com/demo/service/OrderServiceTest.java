package com.demo.service;

import com.demo.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private OrderService orderService;

    //Beforeeach method is called before each test method.Usually it is done for setup
    @BeforeEach
    void setUp() {
        orderService = OrderService.getInstance();
    }


    //Without CC the email is throwing an Exception so checking whether it is throwing an exception when we placeOrder

    //test method like what are we going to test
    @Test
    void placeOrderWithoutCC() {
        Order order = new Order(2, "Book", 100);

        RuntimeException exception = assertThrows(
                RuntimeException.class,         //throwing a runtime Exception
                () -> orderService.placeOrder(order)        //calling a placeOrder method and internally it is calling sendEmail without cc which is going to throw error
        );

        assertEquals("An Exception Occurred", exception.getMessage());
    }

    //place order with CC should not throw any Exception
    @Test
    void placeOrderWithCCException() {
        OrderService orderService = OrderService.getInstance();
        Order order = new Order(1, "Mouse", 200);
        //assertDoesNotThrow is going to check that it doesnot throw any exception
        assertDoesNotThrow(() ->
                orderService.placeOrder(order, "cc@mail.com")
        );

    }
    //another test method
    @Test
    void placeOrderTaxCalculationPositive() {
        Order order = new Order(1, "Pen", 100); //here creating an object with price 100

        // since the tax is 20%
        assertEquals(120, order.getPriceWithTax());
    }

    @Test
    void placeOrderTaxCalculationNegative(){
        Order order = new Order(1, "Pen", 100); //here creating an object with price 100

        assertNotEquals(100,order.getPriceWithTax());
    }
    @Test
    void placeOrderWithCC() {
        Order order = new Order(1, "Laptop", 1000);

        //assertTrue is going to have expected value as true we just need to pass the actual value
        assertTrue(orderService.placeOrder(order, "test@cc.com"));
    }

    //Checking whether the customer is getting notified or not
    @Test
    void placeOrderWithCCCustomerNotification() {
        Order order = new Order(1, "Mobile", 500);

        orderService.placeOrder(order, "cc@mail.com");
        //Customer Notification check
        assertTrue(order.isCustomerNotified());
    }


}