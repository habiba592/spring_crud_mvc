package com.springmvc.service;

import com.springmvc.exception.ResourceNotFoundException;
import com.springmvc.model.User;

import com.springmvc.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserSerive {

    @Autowired
    private UserRepository userRepository;



    public List <User> getAllUsers() {
        return userRepository.findAll();
    }


    public User saveUser(User user) {
        return userRepository.save(user);
    }


    public User getUserById(int id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(id));
    }


    public void deleteUserById(int theId) {
        userRepository.deleteById(theId);
    }



}

