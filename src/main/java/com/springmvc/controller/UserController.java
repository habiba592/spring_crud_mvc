package com.springmvc.controller;
import com.springmvc.exception.ResourceNotFoundException;
import com.springmvc.model.User;

import com.springmvc.model.UserToken;
import com.springmvc.service.UserSerive;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserSerive userSerive;



    @PostMapping("/user")
    public UserToken login(@RequestParam("name") String name, @RequestParam("password") String password) {

        String token = getJWTToken(name);
        UserToken user = new UserToken();
        User userr = new User();

        User users=userSerive.findByUserNameAndPassword(name, password);
        if(users!=null)
        {
            user.setUsername(name);
            user.setPassword(password);
            user.setToken(token);
            return user;
        }
        else
        {
            return null;
        }

    }


    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

    @GetMapping(value = "/getAllUsers")
    public List<User> getAllUsers() {
        return userSerive.getAllUsers();
    }

    @GetMapping(value = "/getUserById/{id}")
    public User getUserById(@PathVariable int id) throws ResourceNotFoundException {
       return userSerive.getUserById(id);
    }

    @PostMapping(value = "/addUser")
            public User addUser(@RequestBody User user) {

         return userSerive.saveUser(user);
    }

   /* @PutMapping(value = "/updateUser/{id}")
            public User updateUser(@PathVariable int id, @RequestBody User user) {

        return userSerive.u(id, user);
    }*/

    @DeleteMapping(value = "/deleteUserById/{id}")
            public void deleteUserById(@PathVariable int id) {
       userSerive.deleteUserById(id);
    }

}

