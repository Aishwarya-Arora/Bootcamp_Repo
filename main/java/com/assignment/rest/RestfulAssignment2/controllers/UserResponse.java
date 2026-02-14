package com.assignment.rest.RestfulAssignment2.controllers;

import lombok.Getter;

@Getter
public class UserResponse {

    private int id;
    private String name;
    private String email;

    // constructor
    public UserResponse(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
