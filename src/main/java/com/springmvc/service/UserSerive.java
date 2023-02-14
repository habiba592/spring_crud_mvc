package com.springmvc.service;

import com.springmvc.exception.ResourceNotFoundException;
import com.springmvc.model.User;

import com.springmvc.model.UserToken;
import com.springmvc.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




public interface UserSerive<T> {
    public List <T> getAllUsers();

    public T saveUser(T entity);

    public T getUserById(int id);


    public void deleteUserById(int theId);

   public T findByUserNameAndPassword(String name, String password);

}

