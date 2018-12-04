package com.ismirnov.healthapp.persist;

public interface DoctorDAO {
    public DoctorEntity findBySpeciality(String speciality);
}