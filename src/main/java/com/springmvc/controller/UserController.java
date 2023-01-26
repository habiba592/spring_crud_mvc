package com.springmvc.controller;

import com.springmvc.model.User;

import com.springmvc.service.UserSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserSerive serive;

    @GetMapping(value = "/getAllUsers")
    public List<User> getAllUsers() {
        return serive.getAllUsers();
    }

    @GetMapping(value = "/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
       return serive.getUserById(id);
    }

    @PostMapping(value = "/addUser")
            public List addUser(@RequestBody User user) {
         return serive.addUser(user);
    }

    @PutMapping(value = "/updateUser/{id}")
            public User updateUser(@PathVariable int id, @RequestBody User user) {

        return serive.updateUser(id, user);
    }

    @DeleteMapping(value = "/deleteUser/{id}")
            public void deleteUser(@PathVariable int id) {
       serive.deleteUser(id);
    }

}

