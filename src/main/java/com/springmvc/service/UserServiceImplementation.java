package com.springmvc.service;
import com.springmvc.model.User;
import com.springmvc.repository.UserRepository;
import config.SecureUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImplementation implements UserSerive<User> {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecureUtils secureUtils;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        user.setSalt(secureUtils.generateSalt());
        user.setHashedPassword(secureUtils.hashPassword(user.getPassword(), user.getSalt()));
      return   userRepository.save(user);
    }

    public User getUserById(int id) {
        return userRepository.findById(id);
    }


    public void deleteUserById(int theId) {
        userRepository.deleteById(theId);
    }

    public User findByUserNameAndPassword(String name, String password) {
        List<User> users = userRepository.findByName(name);
        for (User user : users) {
            String hashedPassword = secureUtils.hashPassword(password, user.getSalt());
            System.out.println("From DB"+user.getHashedPassword());
            System.out.println("Runti"+hashedPassword);
            if (hashedPassword.equals(user.getHashedPassword())) {
                return user;
            }
        }
        return null;
    }
}
