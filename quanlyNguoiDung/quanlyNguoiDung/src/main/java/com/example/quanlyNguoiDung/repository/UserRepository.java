package com.example.quanlyNguoiDung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quanlyNguoiDung.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
