package com.example.quanlyNguoiDung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.quanlyNguoiDung.dto.request.UserCreationREquest;
import com.example.quanlyNguoiDung.dto.request.UserUpdateRequest;
import com.example.quanlyNguoiDung.entity.User;
import com.example.quanlyNguoiDung.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(UserCreationREquest request){
        if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("Username is required");
        }
        if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }
        if (request.getHoTen() == null || request.getHoTen().trim().isEmpty()) {
            throw new IllegalArgumentException("Full name (hoTen) is required");
        }
        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        User user = new User();

        user.setUsername(request.getUsername());

        String encodedPassword = passwordEncoder.encode(request.getPassword());
        user.setPassword(encodedPassword);
        user.setHoTen(request.getHoTen());
        user.setEmail(request.getEmail());
        user.setSdt(request.getSdt());
        user.setMaNhom(request.getMaNhom());
        user.setLoaiNguoiDung(request.getLoaiNguoiDung());

        return userRepository.save(user);
    }

    public User updateUser(String userName, UserUpdateRequest request){
        User user = getUser(userName);

    if (request.getPassword() != null && !request.getPassword().isEmpty()) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        user.setPassword(encodedPassword);
    }
    if (request.getHoTen() != null && !request.getHoTen().trim().isEmpty()) {
        user.setHoTen(request.getHoTen());
    }
    if (request.getEmail() != null && !request.getEmail().trim().isEmpty()) {
        user.setEmail(request.getEmail());
    }
    if (request.getSdt() != null && !request.getSdt().trim().isEmpty()) {
        user.setSdt(request.getSdt());
    }
    if (request.getMaNhom() != null && !request.getMaNhom().trim().isEmpty()) {
        user.setMaNhom(request.getMaNhom());
    }
    if (request.getLoaiNguoiDung() != null && !request.getLoaiNguoiDung().trim().isEmpty()) {
        user.setLoaiNguoiDung(request.getLoaiNguoiDung());
    }

    return userRepository.save(user);
    }

    public void deleteUser(String userName){
        userRepository.deleteById(userName);
    }
    
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String username){
        return userRepository.findById(username).orElseThrow(() -> new RuntimeException("User not found!"));
    }
}
