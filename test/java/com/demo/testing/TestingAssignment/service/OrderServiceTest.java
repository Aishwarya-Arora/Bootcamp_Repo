package com.demo.testing.TestingAssignment.service;

import com.demo.testing.TestingAssignment.domain.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//This is actually injecting the mock objects inside the inject mocks objects
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    //mock creates a fake object which is just like a autowire
    @Mock
    private EmailService emailService;
    //injectmock is used to inject the dependency
    @InjectMocks
    private OrderService orderService;

    @Test
    public void shouldPlaceOrderAndSendEmail() {
        //creating a order object
        Order order = new Order(2, "Phone", 100);
        //calling the method from order service object
        orderService.placeOrder(order);


        // verify tax calculation
        assertEquals(120, order.getPriceWithTax(), 0.01);

        // verify email service called
        verify(emailService).sendEmail(order);

        // verify customer notified flag
        assertTrue(order.isCustomerNotified());
    }

    @Test
    public void shouldPlaceOrderWithCCAndNotifyCustomer() {

        // given
        Order order = new Order(1, "Laptop", 200);

        // mock email service behavior or also called stubbing
        when(emailService.sendEmail(order, "aish@gmail.com"))
                .thenReturn(true);

        // when
        boolean result = orderService.placeOrder(order, "aish@gmail.com");

        // verify return value
        assertTrue(result);

        // verify tax calculation
        assertEquals(240, order.getPriceWithTax(), 0.01);

        // verify email called with cc
        verify(emailService).sendEmail(order, "aish@gmail.com");

        // verify notification flag updated
        assertTrue(order.isCustomerNotified());
    }


}