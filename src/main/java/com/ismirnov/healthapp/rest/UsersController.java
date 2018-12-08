package com.ismirnov.healthapp.rest;

import com.ismirnov.healthapp.persist.UserEntity;
import com.ismirnov.healthapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableSwagger2
@RestController
@RequestMapping("/rest/users")
public class UsersController {
    @Autowired
    UserService userService;

//    @GetMapping(value = "/{id}", produces = {"application/json"})
//    public UserEntity findItem(@PathVariable Integer id) {
//        return userService.searchById(id);
//    }

    @GetMapping(value = "/email/{email}", produces = {"application/json"})
    public List<UserEntity> findItem(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    @PostMapping(value = "/new/{fname}/{lname}/{email}/{pass}/{age}/{gender}", produces = {"application/json"})
    public UserEntity newUser(@PathVariable String fname, @PathVariable String lname, @PathVariable String email, @PathVariable String pass, @PathVariable int age, @PathVariable int gender) {
        UserEntity user = new UserEntity();
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setEmail(email);
        user.setPassword(pass);
        user.setAge(age);
        user.setGender(gender);
        userService.save(user);
        return user;
    }
}
