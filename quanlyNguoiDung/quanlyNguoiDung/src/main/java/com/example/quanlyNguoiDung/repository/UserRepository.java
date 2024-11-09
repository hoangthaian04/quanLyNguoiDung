package com.example.quanlyNguoiDung.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quanlyNguoiDung.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT DISTINCT u.loaiNguoiDung FROM User u")
    List<String> findDistinctUserTypes();

    @Query("SELECT u FROM User u WHERE " +
           "(:hoTen IS NULL OR u.hoTen LIKE %:hoTen%) AND " +
           "(:email IS NULL OR u.email LIKE %:email%)")
    Page<User> findBySearchCriteria(String hoTen, String email, Pageable pageable);
}
