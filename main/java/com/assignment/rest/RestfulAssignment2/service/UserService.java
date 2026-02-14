package com.assignment.rest.RestfulAssignment2.service;

import com.assignment.rest.RestfulAssignment2.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
//creating a list
    private static List<User> users = new ArrayList<>();
    //initializing the list by static block
    static {
        users.add(new User(1, "Aishwarya", "aish@mail.com"));
        users.add(new User(2, "Raj", "raj@mail.com"));
    }
//to add all the users when calling post request
    public void addUser(User user) {
        users.add(user);
    }
//reteriving all the user
    public List<User> getAllUsers() {
        return users;
    }
    public void deleteUser(int id){
        Optional<User> optional=users.stream().filter(u->u.getId()==id).findFirst();
        if(optional.isPresent()){
            users.remove(optional.get());
        }
    }
    //getting the user by id
    public User getUserById(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }
}