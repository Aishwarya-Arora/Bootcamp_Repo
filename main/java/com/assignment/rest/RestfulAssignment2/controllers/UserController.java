package com.assignment.rest.RestfulAssignment2.controllers;

import com.assignment.rest.RestfulAssignment2.model.User;
import com.assignment.rest.RestfulAssignment2.service.UserService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User Controller", description = "APIs for managing users")
public class UserController {

    @Autowired
    private UserService userService;

    //telling that it will accept application/xml and should get application/xml
    @Operation(
            summary = "Create a new user",
            description = "Saves a new user in the system"
    )
    @ApiResponse(responseCode = "200", description = "User created successfully")
    @PostMapping
    public User createUser(@RequestBody User user) {
        userService.addUser(user);      //calling the userService adduser method to add the value
        return user;
    }
//    @PostMapping
//    public UserResponse createUser(@RequestBody User user) {
//
//        userService.addUser(user);
//
//        return new UserResponse(
//                user.getId(),
//                user.getName(),
//                user.getEmail()
//        );
//    }

    @Operation(
            summary = "Delete a user",
            description = "Deletes user based on ID"
    )
    @ApiResponse(responseCode = "200", description = "User deleted successfully")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
    @Operation(
            summary = "Get all users",
            description = "Fetches the list of all registered users"
    )
    @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();       //retierving all the users
    }
}