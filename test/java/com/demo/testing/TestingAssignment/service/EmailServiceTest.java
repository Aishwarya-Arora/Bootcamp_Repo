package com.demo.testing.TestingAssignment.service;

import com.demo.testing.TestingAssignment.domain.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {

    private EmailService emailService = new EmailService();


    @Test
    public void shouldThrowExceptionWhenSendingEmail() {

        Order order = new Order();

        try {
           assertThrows(RuntimeException.class,()-> emailService.sendEmail(order)); //throwing a run time exception when we call sendEmail withoyt cc
        } finally {
            // verify flag updated before exception
            assertFalse(order.isCustomerNotified());
        }
    }


    @Test
    public void shouldSendEmailWithCCSuccessfully() {

        Order order = new Order();

        boolean result = emailService.sendEmail(order, "aish@gmail.com");

        assertTrue(result); //when sending a email with cc it should return true
        assertTrue(order.isCustomerNotified());
    }

}