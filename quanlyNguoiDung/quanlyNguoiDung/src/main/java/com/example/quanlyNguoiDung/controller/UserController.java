package com.example.quanlyNguoiDung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.quanlyNguoiDung.dto.request.UserCreationREquest;
import com.example.quanlyNguoiDung.dto.request.UserUpdateRequest;
import com.example.quanlyNguoiDung.entity.User;
import com.example.quanlyNguoiDung.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestBody UserCreationREquest request) {        
        return userService.createUser(request);
    }
    @GetMapping("/users")
    List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/users/{userName}")
    User getUser(@PathVariable("userName") String userName){
        return userService.getUser(userName);
    }
    @PutMapping("/users/{userName}")
    User updateUser(@PathVariable String userName, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userName, request);
    }
    @DeleteMapping("/users/{userName}")
    String deleteUser(@PathVariable String userName){
        userService.deleteUser(userName);
        return "User has been deleted!";
    }
}
