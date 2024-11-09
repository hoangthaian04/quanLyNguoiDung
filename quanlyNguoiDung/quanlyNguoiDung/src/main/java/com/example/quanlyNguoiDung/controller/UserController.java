package com.example.quanlyNguoiDung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.quanlyNguoiDung.dto.request.UserCreationREquest;
import com.example.quanlyNguoiDung.dto.request.UserUpdateRequest;
import com.example.quanlyNguoiDung.entity.User;
import com.example.quanlyNguoiDung.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users") //thêm người dùng
    public User createUser(@RequestBody UserCreationREquest request) {        
        return userService.createUser(request);
    }
    @GetMapping("/users") //Lấy danh sách người dùng
    List<User> getAllUsers(){
        return userService.getUsers();
    }
    @GetMapping("/users/{userName}") //Tìm người dùng theo username
    User getUser(@PathVariable("userName") String userName){
        return userService.getUser(userName);
    }
    @GetMapping("/users/types") //Lấy danh sách loại người dùng
    public List<String> getUserTypes() {
        return userService.getDistinctUserTypes();
    }
    @GetMapping("/users/page") //Lấy danh sách người dùng phân trang
    public Page<User> getUsersPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return userService.getUsers(page, size);
    }
    @GetMapping("/search/users") //Tìm người dùng phân trang
    public Page<User> searchUsers(
            @RequestParam(required = false) String hoTen,
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userService.searchUsers(hoTen, email, pageable);
    }
    @PutMapping("/users/{userName}") //Cập nhật thông tin người dùng
    User updateUser(@PathVariable String userName, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userName, request);
    }
    @DeleteMapping("/users/{userName}") //Xóa người dùng
    String deleteUser(@PathVariable String userName){
        userService.deleteUser(userName);
        return "User has been deleted!";
    }
}
