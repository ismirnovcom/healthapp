package com.ismirnov.healthapp.service;

import com.ismirnov.healthapp.persist.DoctorEntity;
import com.ismirnov.healthapp.persist.UserEntity;
import com.ismirnov.healthapp.repositories.DoctorDAO;
import com.ismirnov.healthapp.repositories.DoctorEntityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorDAO doctorDAO;
    private UserService userService;

    @Autowired
    public DoctorServiceImpl(DoctorDAO doctorDAO, UserService userService) {
        this.doctorDAO = doctorDAO;
        this.userService = userService;
    }

    @Override
    public List<DoctorEntity> getBySpecialityCode(String specialityCode) {
        return doctorDAO.findBySpecialityCode(specialityCode);
    }

/*	@Override
	public List<DoctorEntity> findAll() {
		return doctorDAO.findAll();
	}

	@Override
	public int findCount() {
		return doctorDAO.findAllCount();
	}

	@Override
	public DoctorEntity findByUserEmailAddress(String email) {
		UserEntity user = null;
		try {
			user = userService.getByEmail(email);
		} catch (UserNotFoundException e) {
			return null;
		}
		return this.findByUserId(user.getId());
	}

	@Override
	public DoctorEntity findByUserId(int userId) {
		return doctorDAO.findByUserId(userId);
	}
	
	@Override
	public void save(DoctorEntity doctor) {
	}

	@Override
	public List<DoctorEntity> findByLocation(String location) {
		return null;
	}

	@Override
	public List<DoctorEntity> findByHospital(String hospitalName) {
		return null;
	}

	@Override
	public void addDoctor(UserEntity user) {
			Doctor doctor = new Doctor();
			doctor.setUser(user);
			doctor.setSpecialityCode("PHYSICIAN");
			doctorDAO.save(doctor);
	}*/

}
