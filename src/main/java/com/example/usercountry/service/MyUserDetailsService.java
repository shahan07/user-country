package com.example.usercountry.service;


import com.example.usercountry.entity.Users;
import com.example.usercountry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

       Users users = repository.findByName(name);
        return new org.springframework.security.core.userdetails.User(users.getUserName(), users.getPassword(), new ArrayList<>());
    }
}