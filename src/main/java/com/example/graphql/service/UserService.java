package com.example.graphql.service;


import com.example.graphql.entity.user;
import com.example.graphql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public List<user> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<user> getById(Long id){
        return userRepository.findById(id);
    }
    public user createUser(user User){
        return userRepository.save(User);
    }
    public user updateUser(Long id, user userDetails) {
        user User = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        User.setName(userDetails.getName());
        User.setEmail(userDetails.getEmail());
        return userRepository.save(User);
    }
    public void deleteUser(Long id){
        user User = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(User);
    }

}
