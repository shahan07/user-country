package com.example.usercountry.repository;

import com.example.usercountry.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;




public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByName(String name);
}
