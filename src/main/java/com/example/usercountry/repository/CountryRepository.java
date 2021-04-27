package com.example.usercountry.repository;


import com.example.usercountry.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findByName(String name);
}
