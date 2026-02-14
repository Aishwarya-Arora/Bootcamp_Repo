package com.assignment.rest.RestfulAssignment2.controllers;

import com.assignment.rest.RestfulAssignment2.model.User;
import com.assignment.rest.RestfulAssignment2.service.UserService;
import io.swagger.v3.oas.annotations.links.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class HateoasController {
    @Autowired
    private UserService userService;

    // Get single user by id with HATEOAS link to all users
    @GetMapping("/{id}")
    public EntityModel<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return null; // or ResponseEntity.notFound().build()
        }

        // Create HATEOAS link to all users
        Link allUsersLink = (Link) linkTo(methodOn(HateoasController.class).getAllUsers())
                .withRel("all-users");

        // Wrap user in EntityModel and add link
        return EntityModel.of(user, (org.springframework.hateoas.Link) allUsersLink);
    }


    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
