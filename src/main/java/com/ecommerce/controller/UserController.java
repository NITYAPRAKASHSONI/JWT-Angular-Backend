package com.ecommerce.controller;

import com.ecommerce.entity.User;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @PostConstruct
    public void initRolesAndUsers(){
        userService.initRoleAndUser();
    }

    @PostMapping(path = "/registerNewUser")
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
    }

    @GetMapping("/forAdmin")
    @PreAuthorize("hasRole('admin')")
    public String forAdmin(){
        return "This url is only accessible by admin";
    }

    @GetMapping("/forUser")
    @PreAuthorize("hasRole('user')")
    public String forUser(){
        return "This url is accessible is only user";
    }
}
