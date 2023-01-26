package com.springmvc.service;

import com.springmvc.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserSerive {


    private List<User> users = new ArrayList<User>();
    private int nextId = 1;

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(@PathVariable int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }


    public List addUser(@RequestBody User user) {
        user.setId(nextId++);
        users.add(user);
        return users;
    }



    public User updateUser(@PathVariable int id, @RequestBody User user) {

        for (int i = 0; i < users.size(); i++) {
            try {
                if (users.get(i).getId() == id) {
                    users.get(i).setName(user.getName());
                    return users.get(i);
                }
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("Error: Index " + users.get(i).getId() + " is out of range. The size of the list is " + users.size());

            }
        }
        return null;
    }

    public void deleteUser(@PathVariable int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                return;
            }
        }
    }

}

