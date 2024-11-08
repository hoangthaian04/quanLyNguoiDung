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

        user.setHoTen(request.getHoTen());
        user.setEmail(request.getEmail());
        user.setSdt(request.getSdt());
        user.setMaNhom(request.getMaNhom());
        user.setLoaiNguoiDung(request.getLoaiNguoiDung());

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
