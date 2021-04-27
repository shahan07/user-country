package com.example.usercountry.service;


import com.example.usercountry.entity.Country;
import com.example.usercountry.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public Country saveCountry(Country country) {

        return countryRepository.save(country);
    }

    public List<Country> saveCountry(List<Country>country) {

        return countryRepository.saveAll(country);
    }

    public List<Country> getCountry() {

        return countryRepository.findAll();
    }

    public Country getCountryById(int id) {

        return countryRepository.findById(id).orElse(null);
    }

    public Country getCountryByName(String name) {


        return countryRepository.findByName(name);
    }

    public String deleteCountry(int cid) {
        countryRepository.deleteById(cid);
        return "Country removed !! " + cid;
    }

    public Country updateCountry(Country country) {
        Country existingCountry = countryRepository.findById(country.getCid()).orElse(null);
        existingCountry.setCountryName(country.getCountryName());

        return countryRepository.save(existingCountry);
    }




}