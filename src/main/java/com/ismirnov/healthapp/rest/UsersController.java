package com.ismirnov.healthapp.rest;

import com.ismirnov.healthapp.persist.UserDAO;
import com.ismirnov.healthapp.persist.UserEntity;
import com.ismirnov.healthapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@EnableSwagger2
@RestController
@RequestMapping("/rest/users")
public class UsersController {
//    @Autowired
//    UserDAO user;

    @Autowired
    UserService userService;

//    @GetMapping(value = "/{id}", produces = {"application/json"})
//    public UserEntity findItem(@PathVariable Integer id) {
//        return user.searchById(id);
//    }

    @GetMapping(value = "/email/{email}", produces = {"application/json"})
    public UserEntity findItem(@PathVariable String email) {
        return userService.getByEmail(email);
    }
}
