package com.springmvc.repository;

import com.springmvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);
    List<User> findByName(String name);
    User findByNameAndPassword(String name, String password);
}
