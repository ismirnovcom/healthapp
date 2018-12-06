package com.ismirnov.healthapp.repositories;

import com.ismirnov.healthapp.persist.DoctorEntity;

import java.util.List;

public interface DoctorDAO {
    public List<DoctorEntity> findBySpecialityCode(String speciality);

}