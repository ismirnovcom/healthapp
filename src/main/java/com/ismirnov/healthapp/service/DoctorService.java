package com.ismirnov.healthapp.service;

import com.ismirnov.healthapp.persist.DoctorEntity;

import java.util.List;


public interface DoctorService {

    List<DoctorEntity> getBySpecialityCode(String specialityCode);

}
