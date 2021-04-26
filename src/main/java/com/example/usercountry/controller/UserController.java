package com.example.usercountry.controller;


import com.example.usercountry.entity.AuthRequest;
import com.example.usercountry.entity.Jsn;
import com.example.usercountry.entity.Users;
import com.example.usercountry.service.UsersService;
import com.example.usercountry.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UsersService service;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping("/addUser")
       public Users addUsers (@RequestBody Users users)  {

               return service.saveUsers(users);
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


    @GetMapping("/users")
    public List<Users> findAllPerson() {

        return service.getUsers();
    }

    @GetMapping("/userById/{id}")
    public Users findPersonById(@PathVariable int id) {
        return service.getUsersById(id);
    }

    @GetMapping(path = "/ByName")
    @ResponseBody
    public Jsn ByName(@RequestParam(value = "name") String name) {
        return service.getByName(name);
    }
    //@GetMapping("/person/{name}")
   // public Person findPersonByName(@PathVariable String name) {


       // return service.getPersonByName(name);}

    @PutMapping("/update")
    public Users updatePerson(@RequestBody Users users) {

        return service.updateUsers(users);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUsers(@PathVariable int id) {

        return service.deleteUsers(id);
    }

}
