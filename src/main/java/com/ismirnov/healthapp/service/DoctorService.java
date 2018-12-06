package com.ismirnov.healthapp.service;

import com.ismirnov.healthapp.persist.DoctorEntity;

import java.util.List;


public interface DoctorService {
	
//	void save(DoctorEntity doctor);

	List<DoctorEntity> getBySpecialityCode(String specialityCode);
	
/*	List<Doctor> findByLocation(String location);
	
	List<Doctor> findByHospital(String hospitalName);

	List<Doctor> findAll();
	
	Doctor findByUserEmailAddress(String email);
	
	int findCount();
	
	Doctor findByUserId(int userId);

	void addDoctor(User user);*/
}
