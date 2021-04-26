package com.example.usercountry.service;


import com.example.usercountry.entity.Jsn;
import com.example.usercountry.entity.Users;
import com.example.usercountry.exception.ApiRequestException;
import com.example.usercountry.repository.UserRepository;
import com.example.usercountry.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UsersService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository repository;

    public Users saveUsers(Users users) {
        try {
            users.setPassword(passwordEncoder.encode(users.getPassword()));
            return repository.save(users);
        } catch (Exception e) {
            throw new ApiRequestException("Email/name not unique.Please retry with another email/name");

        }
    }

    public List<Users> saveUsers(List<Users>users) {

        return repository.saveAll(users);
    }

    public List<Users> getUsers() {

        return repository.findAll();
    }

    public Users getUsersById(int id) {

        return repository.findById(id).orElse(null);
    }

    public Users getUsersByName(String name) {


        return repository.findByName(name);
    }

    public String deleteUsers(int id) {
        repository.deleteById(id);
        return "person removed !! " + id;
    }

    public Users updateUsers(Users users) {
        Users existingPerson = repository.findById(users.getId()).orElse(null);
        existingPerson.setFullName(users.getFullName());

        return repository.save(existingPerson);
    }



    public Jsn getByName(String name) {


        if (repository.findByName(name) != null) {

            return Jsn.builder()
                    .taken(true)
                    .build();
        }

        return Jsn.builder()
                .taken(false)
                .build();
    }


}