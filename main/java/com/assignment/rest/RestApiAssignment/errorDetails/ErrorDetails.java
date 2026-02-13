package com.assignment.rest.RestApiAssignment.errorDetails;

import lombok.Getter;

import java.time.LocalDate;

//getter is used to have the getter methods
@Getter
//this is the custom exception details that a Exception can have
public class ErrorDetails {
    private String msg;
    private LocalDate time;
    public ErrorDetails(String msg, LocalDate time){
        this.msg=msg;
        this.time=time;
    }
}
