package com.demo.service;

import com.demo.domain.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
public class EmailServiceTest {

    //Checking the email that is sent without CC is going to send an Exception or not
    @Test
    void sendEmailWithoutCCPositive() {
        EmailService emailService = EmailService.getInstance();
        Order order = new Order(1, "Book", 100);
        //assertThrows check that the specific exception is being thrown or not
        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> emailService.sendEmail(order)
        );
        //assertEquals checks whether the actual value is same as the expected value
        assertEquals("An Exception Occurred", ex.getMessage());
    }

    @Test
    void sendEmailWithoutCCNegative() {
        EmailService emailService = EmailService.getInstance();
        Order order = new Order(1, "Book", 100);
        //assertThrows check that the specific exception is being thrown or not
        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> emailService.sendEmail(order)
        );
        //assertNotEquals checks whether the actual value is not same as the expected value
        assertNotEquals("A Exception", ex.getMessage());
    }

    //This method is going to check whether send Email method without CC the customer is not getting Notified
    @Test
    void sendEmailWithoutCCShouldSetCustomerNotifiedFalse() {
        EmailService emailService = EmailService.getInstance();
        Order order = new Order(1, "Pen", 50);

        try {
            emailService.sendEmail(order);
        } catch (RuntimeException ignored) {
        }
        //assertFalse will check the actual value with false it always checks for boolean
        assertFalse(order.isCustomerNotified());
    }

    //It tests that the sendEmail with cc is going to return true or not
    @Test
    void sendEmailWithCCShouldReturnTrue() {
        EmailService emailService = EmailService.getInstance();
        Order order = new Order(1, "Notebook", 80);
        //assertTrue is going to test the actual value is returning true or not
        assertTrue(emailService.sendEmail(order, "cc@mail.com"));
    }

    @Test
    void sendEmailWithCCException() {
        EmailService emailService = EmailService.getInstance();
        Order order = new Order(1, "Notebook", 80);
        //It is going to check whether the sendEmail with cc method is not going to return a Exception
        assertDoesNotThrow(() ->
                emailService.sendEmail(order, "cc@mail.com"));
    }

    //It tests that Customer is getting notified or not
    @Test
    void sendEmailWithCCShouldNotifyCustomer() {
        EmailService emailService = EmailService.getInstance();
        Order order = new Order(1, "Bag", 300);

        emailService.sendEmail(order, "cc@mail.com");

        assertTrue(order.isCustomerNotified());
    }

}