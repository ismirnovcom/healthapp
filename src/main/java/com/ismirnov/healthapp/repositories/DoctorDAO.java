package com.ismirnov.healthapp.repositories;

import com.ismirnov.healthapp.persist.DoctorEntity;

public interface DoctorDAO {
    public DoctorEntity findBySpeciality(String speciality);
}