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
	
/*	final static Logger logger = LoggerFactory.getLogger(DoctorSearchController.class);
	
	@Autowired
	DoctorService docService;
	
	@GetMapping(value="/doctor/count")
	public DoctorInfo getDoctorsCount(ModelMap model) {
		int count = docService.findCount();
		return new DoctorInfo("All doctors count", count);
	}
    
	@RequestMapping(value="/doctor/{code}", method= RequestMethod.GET)
	public DoctorInfo getBySpecialityCode(ModelMap model, @PathVariable("code") String code) {
		List<Doctor> doctors = docService.findBySpeciality(code);
		if(doctors == null) {
			return new DoctorInfo("No Doctors found!", null);
		}
		return new DoctorInfo("Doctors found", doctors);
	}
	
	@GetMapping(value="/doctor", produces="application/json")
	public DoctorInfo findAll(ModelMap model) {
		
		List<Doctor> doctors = docService.findAll();
		if(doctors == null) {
			return new DoctorInfo("No Doctors found!", null);
		}
		return new DoctorInfo("Doctors found", doctors);
	}*/
}
