package com.ismirnov.healthapp.rest;

import com.ismirnov.healthapp.persist.DoctorEntity;
import com.ismirnov.healthapp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableSwagger2
@RestController
@RequestMapping("/rest/doctor")
public class DoctorSearchController {

    @Autowired
    DoctorService docService;

//    @GetMapping(value = "/{id}", produces = {"application/json"})
//    public UserEntity findItem(@PathVariable Integer id) {
//        return user.searchById(id);
//    }

    @GetMapping(value = "/{code}", produces = {"application/json"})
    public List<DoctorEntity> findItem(@PathVariable String code) {
        return docService.getBySpecialityCode(code);
    }
	
}
