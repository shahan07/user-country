package com.example.usercountry.service;


import com.example.usercountry.entity.Country;
import com.example.usercountry.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository repository;

    public Country saveCountry(Country country) {

        return repository.save(country);
    }

    public List<Country> saveCountry(List<Country>country) {

        return repository.saveAll(country);
    }

    public List<Country> getCountry() {

        return repository.findAll();
    }

    public Country getCountryById(int id) {

        return repository.findById(id).orElse(null);
    }

    public Country getCountryByName(String name) {


        return repository.findByName(name);
    }

    public String deleteCountry(int cid) {
        repository.deleteById(cid);
        return "Country removed !! " + cid;
    }

    public Country updateCountry(Country country) {
        Country existingCountry = repository.findById(country.getCid()).orElse(null);
        existingCountry.setCountryName(country.getCountryName());

        return repository.save(existingCountry);
    }




}