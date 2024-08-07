package com.example.graphql.controller;

import com.example.graphql.entity.user;
import com.example.graphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class apiController {
    @Autowired
    public UserService service;

    @QueryMapping
    public List<user> getAll(){
        return service.getAllUsers();
    }

    @QueryMapping
    public user getById(@Argument Long id){
        return service.getById(id).orElse(null);
    }

    @MutationMapping
    public user addUser(@Argument String name, @Argument String email){
        user User = new user();
        User.setEmail(email);
        User.setName(name);
        return service.createUser(User);
    }

    @MutationMapping
    public user updateUser(@Argument Long id, @Argument String name, @Argument String email) {
        user User = new user();
        User.setName(name);
        User.setEmail(email);
        return service.updateUser(id, User);
    }

    @MutationMapping
    public boolean deleteUser(@Argument Long id) {
        service.deleteUser(id);
        return true;
    }
}
