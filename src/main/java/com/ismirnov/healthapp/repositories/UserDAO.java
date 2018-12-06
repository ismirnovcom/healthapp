package com.ismirnov.healthapp.repositories;

import com.ismirnov.healthapp.persist.UserEntity;

import java.util.List;

public interface UserDAO {
    public UserEntity searchById(Integer id);
    public List<UserEntity> findByEmail(String email);
}