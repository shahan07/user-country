package com.example.usercountry.controller;

import com.example.usercountry.entity.AuthRequest;
import com.example.usercountry.entity.Country;
import com.example.usercountry.service.CountryService;
import com.example.usercountry.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CountryController {


    @Autowired
    private CountryService service;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping("/addCountry")
    public Country addCountry (@RequestBody Country country)  {

        return service.saveCountry(country);
    }



    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{

        try {


            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getName(),authRequest.getPassword())
            );
        }
        catch (Exception ex)
        {
            throw new Exception("Invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getName());
    }


    @GetMapping("/Country")
    public List<Country> findAllCountry() {

        return service.getCountry();
    }

    @GetMapping("/CountryById/{id}")
    public Country findCountryById(@PathVariable int id) {
        return service.getCountryById(id);
    }


    @PutMapping("/update")
    public Country updateCountry(@RequestBody Country country) {

        return service.updateCountry(country);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUsers(@PathVariable int id) {

        return service.deleteCountry(id);
    }

}
